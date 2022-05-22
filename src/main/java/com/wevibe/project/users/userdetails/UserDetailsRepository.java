package com.wevibe.project.users.userdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDetailsRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<UserDetails> getAll() {
        return jdbcTemplate.query("SELECT username, email, first_name, last_name, gender, address_user, phone_number FROM users",
                BeanPropertyRowMapper.newInstance(UserDetails.class));
    }

    public UserDetails getUserDetailsById(Long id) {
        return jdbcTemplate.queryForObject("SELECT id_user, username, email, first_name, last_name, address_user, phone_number, gender FROM users WHERE " +
                "id_user = ?", BeanPropertyRowMapper.newInstance(UserDetails.class), id);
    }

    public int update(UserDetails userDetails) {
        return jdbcTemplate.update("UPDATE users SET username=?, email=?, first_name=?, last_name=?, address_user=?, phone_number=?, gender=? WHERE users.id_user=?",
                userDetails.getUsername(), userDetails.getEmail(), userDetails.getFirstName(), userDetails.getLastName(), userDetails.getUserAddress(), userDetails.getPhoneNumber(), userDetails.getGender(), userDetails.getIdUser());
    }

    public int delete(Long id) {
        return jdbcTemplate.update("DELETE FROM users WHERE id_user=?", id);
    }
}
