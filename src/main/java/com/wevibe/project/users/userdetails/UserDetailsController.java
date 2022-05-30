package com.wevibe.project.users.userdetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users/details")
public class UserDetailsController {
    @Autowired
    UserDetailsRepository userDetailsRepository;

    @Autowired
    JdbcTemplate jdbcTemplate;

    @GetMapping("")
    public List<UserDetails> getAll() {
        return userDetailsRepository.getAll();
    }

    @GetMapping("/{id}")
    public UserDetails getById(@PathVariable("id") Long id) {
        return userDetailsRepository.getUserDetailsById(id);
    }

    @GetMapping("event/{id}")
    public List<UserDetails> getAllAtEvent(@PathVariable("id") Long id) {
        return userDetailsRepository.getAllAtEvent(id);
    }

    @PutMapping("/{id}")
    public int update(@PathVariable("id") Long id, @RequestBody UserDetails updatedUserDetails) {
        UserDetails userDetails = userDetailsRepository.getUserDetailsById(id);

        if (updatedUserDetails != null) {
            userDetails.setUsername(updatedUserDetails.getUsername());
            userDetails.setEmail(updatedUserDetails.getEmail());
            userDetails.setFirstName(updatedUserDetails.getFirstName());
            userDetails.setLastName(updatedUserDetails.getLastName());
            userDetails.setGender(updatedUserDetails.getGender());
            userDetails.setPhoneNumber(updatedUserDetails.getPhoneNumber());
            userDetails.setUserAddress(updatedUserDetails.getUserAddress());

            userDetailsRepository.update(userDetails);

            return 1;
        } else {
            return -1;
        }
    }

    @PatchMapping("/{id}")
    public int partiallyUpdate(@PathVariable("id") Long id, @RequestBody UserDetails updatedUserDetails) {
        UserDetails userDetails = userDetailsRepository.getUserDetailsById(id);

        if (userDetails != null) {
            if (updatedUserDetails.getUsername() != null) userDetails.setUsername(updatedUserDetails.getUsername());
            if (updatedUserDetails.getEmail() != null) userDetails.setEmail(updatedUserDetails.getEmail());
            if (updatedUserDetails.getFirstName() != null) userDetails.setFirstName(updatedUserDetails.getFirstName());
            if (updatedUserDetails.getLastName() != null) userDetails.setLastName(updatedUserDetails.getLastName());
            if (updatedUserDetails.getUserAddress() != null) userDetails.setUserAddress(updatedUserDetails.getUserAddress());
            if (updatedUserDetails.getGender() != null) userDetails.setGender(updatedUserDetails.getGender());
            if (updatedUserDetails.getPhoneNumber() != null)
                userDetails.setPhoneNumber(updatedUserDetails.getPhoneNumber());

            userDetailsRepository.update(userDetails);

            return 1;
        } else {
            return -1;
        }
    }

    @DeleteMapping("/{id}")
    public int delete(@PathVariable("id") Long id) {
        return userDetailsRepository.delete(id);
    }

}

