package com.wevibe.project.users;

import com.wevibe.project.users.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("")
    public List<User> getAll() {
        return userRepository.getAll();
    }

    @GetMapping("/{id}")
    public User getById(@PathVariable("id") Long id) {
        return userRepository.getUserById(id);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") Long id, @RequestBody User updatedUser) {
        User user = userRepository.getUserById(id);

        if (updatedUser != null) {
            user.setUsername(updatedUser.getUsername());
            user.setEmail(updatedUser.getEmail());

            userRepository.update(user);

            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") Long id, @RequestBody User updatedUser) {
        User user = userRepository.getUserById(id);

        if (user != null) {
            if (updatedUser.getUsername() != null) user.setUsername(updatedUser.getUsername());
            if (updatedUser.getEmail() != null) user.setEmail(updatedUser.getEmail());

            userRepository.update(user);

            return 1;
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") Long id) {
        return userRepository.delete(id);
    }

}
