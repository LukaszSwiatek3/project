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
        return jdbcTemplate.query("SELECT id_opinion, rating, description, id_opinion_author, opinion_time, id_event FROM opinions",
                BeanPropertyRowMapper.newInstance(Opinion.class));
    }

    public List<Opinion> getAllByUserId(Long idUser) {
        return jdbcTemplate.query("SELECT id_opinion, rating, description, id_opinion_author, opinion_time, id_event FROM opinions WHERE "
                + "id_opinion_author = ?", BeanPropertyRowMapper.newInstance(Opinion.class), idUser);
    }

    public List<Opinion> getAllByEventId(Long idEvent) {
        return jdbcTemplate.query("SELECT id_opinion, rating, description, id_opinion_author, opinion_time, id_event FROM opinions WHERE "
                + "id_event = ?", BeanPropertyRowMapper.newInstance(Opinion.class), idEvent);
    }

    public Opinion getOpinionById(Long idOpinion) {
        return jdbcTemplate.queryForObject("SELECT id_opinion, description, id_event, id_opinion_author, opinion_time, rating FROM opinions WHERE "
                + "id_opinion = ?", BeanPropertyRowMapper.newInstance(Opinion.class), idOpinion);
    }

    public int save(List<Opinion> opinions) {
        opinions.forEach(opinion -> jdbcTemplate
                .update("INSERT INTO opinions(rating, description, id_opinion_author, opinion_time, id_event) " +
                                "VALUES(?, ?, ?, ?, ?)",
                        opinion.getRating(), opinion.getDescription(), opinion.getIdOpinionAuthor(),
                        opinion.getOpinionTime(), opinion.getIdEvent()
                ));

        return 1;
    }

    public int update(Opinion opinion) {
        return jdbcTemplate.update("UPDATE opinions SET rating=?, description=?, id_opinion_author=?, opinion_time=?, id_event=? WHERE id_event=?",
                opinion.getRating(), opinion.getDescription(), opinion.getIdOpinionAuthor(),
                opinion.getOpinionTime(), opinion.getIdEvent()
        );
    }

    public int delete(Long id) {
        return jdbcTemplate.update("DELETE FROM opinions WHERE id_opinion=?", id);
    }


}
