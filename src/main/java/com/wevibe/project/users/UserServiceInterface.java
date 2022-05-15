package com.wevibe.project.users;


import com.wevibe.project.registration.UserRegistrationModel;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserServiceInterface extends UserDetailsService{
    User save(UserRegistrationModel registrationModel);
}

