package com.wevibe.project.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("")
    public List<User> getAll() {
        return jdbcTemplate.query("SELECT username, email   FROM users",
                BeanPropertyRowMapper.newInstance(User.class));
    }

//    @GetMapping("/{event}")
//    public List<User> getAllUserTakePartIn(Event event) {
//        return jdbcTemplate.query("SELECT username u FROM users FULL JOIN events e ON u.id_event = e.id_event WHERE e.name_event=?",
//                BeanPropertyRowMapper.newInstance(User.class));
//    }
}
