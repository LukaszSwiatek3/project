package com.wevibe.project.users.service;


import com.wevibe.project.registration.UserRegistrationModel;
import com.wevibe.project.users.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServiceInterface extends UserDetailsService{
    User save(UserRegistrationModel registrationModel);
}

