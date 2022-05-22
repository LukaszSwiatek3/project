package com.wevibe.project.opinions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OpinionRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Opinion> getAll() {
        return jdbcTemplate.query("SELECT id_opinion, rating, opinion_author, opinion_event, opinion_time, description FROM opinions",
                BeanPropertyRowMapper.newInstance(Opinion.class));
    }

    public List<Opinion> getAllByUserId(Long idUser) {
        return jdbcTemplate.query("SELECT id_opinion, rating, opinion_author, opinion_event, opinion_time, description FROM opinions WHERE "
                + "opinion_author = ?", BeanPropertyRowMapper.newInstance(Opinion.class), idUser);
    }

    public List<Opinion> getAllByEventId(Long idEvent) {
        return jdbcTemplate.query("SELECT id_opinion, rating, opinion_author, opinion_event, opinion_time, description FROM opinions WHERE "
                + "opinion_event = ?", BeanPropertyRowMapper.newInstance(Opinion.class), idEvent);
    }

    public Opinion getOpinionById(Long idOpinion) {
        return jdbcTemplate.queryForObject("SELECT id_opinion, rating, opinion_author, opinion_event, opinion_time, description FROM opinions WHERE "
                + "opinion_event = ?", BeanPropertyRowMapper.newInstance(Opinion.class), idOpinion);
    }

    public int save(List<Opinion> opinions) {
        opinions.forEach(opinion -> jdbcTemplate
                .update("INSERT INTO opinions(rating, opinion_author, opinion_event, opinion_time, description) " +
                                "VALUES(?, ?, ?, ?, ?)",
                        opinion.getRating(), opinion.getDescription(), opinion.getOpinionAuthor(),
                        opinion.getOpinionTime(), opinion.getOpinionEvent()
                ));

        return 1;
    }

    public int update(Opinion opinion) {
        return jdbcTemplate.update("UPDATE opinions SET rating=?, opinion_author=?, opinion_event=?, opinion_time=?, description=? WHERE id_opinion=?",
                opinion.getRating(), opinion.getDescription(), opinion.getOpinionAuthor(),
                opinion.getOpinionTime(), opinion.getOpinionEvent()
        );
    }

    public int delete(Long id) {
        return jdbcTemplate.update("DELETE FROM opinions WHERE id_opinion=?", id);
    }


}
