package com.wevibe.project.users.repository;

import com.wevibe.project.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<User> getAll() {
        return jdbcTemplate.query("SELECT id_user, username, email FROM users", BeanPropertyRowMapper.newInstance(User.class));
    }

    public User getUserById(Long id) {
        return jdbcTemplate.queryForObject("SELECT id_user, username, email FROM users WHERE " + "id_user = ?", BeanPropertyRowMapper.newInstance(User.class), id);
    }

    public int update(User user) {
        return jdbcTemplate.update("UPDATE users SET username=?, email=? WHERE id_user=?", user.getUsername(), user.getEmail(), user.getIdUser());
    }


    public int delete(Long id) {
        return jdbcTemplate.update("DELETE FROM users WHERE id_user=?", id);
    }

}
