package com.wevibe.project.tags;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class TagRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Tag> getAll() {
        return jdbcTemplate.query("SELECT id_tag, name_tag,  comment FROM tags",
                BeanPropertyRowMapper.newInstance(Tag.class));
    }

    public List<Tag> getAllForEvent(Long id) {
        return jdbcTemplate.query("SELECT id_tag, name_tag,  comment \n" +
                        "FROM tags t\n" +
                        "JOIN events_tags et ON t.id_tag = et.tag_id\n" +
                        "JOIN events e ON e.id_event = et.event_id\n" +
                        "WHERE " + "id_event = ?",
                BeanPropertyRowMapper.newInstance(Tag.class), id);
    }

    public Tag getTagById(Long id) {
        return jdbcTemplate.queryForObject("SELECT id_tag, name_tag, comment " +
                "FROM tags WHERE " + "id_tag = ?", BeanPropertyRowMapper.newInstance(Tag.class), id);
    }

    public int save(List<Tag> tags) {
        tags.forEach(tag -> jdbcTemplate
                .update("INSERT INTO tags (id_tag, name_tag, comment) VALUES(?, ?, ?)",
                        tag.getIdTag(), tag.getNameTag(), tag.getComment()
                ));
        return 1;
    }

    public int update(Tag tag) {
        return jdbcTemplate.update("UPDATE tags SET id_tag=?, name_tag=?, comment=? " +
                        "WHERE id_tag=?",
                tag.getIdTag(), tag.getNameTag(), tag.getComment()
        );

    }

    public int delete(Long id) {
        return jdbcTemplate.update("DELETE FROM tags WHERE id_tag=?", id);
    }

}
