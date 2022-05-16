package com.wevibe.project.users;

import com.wevibe.project.registration.UserRegistrationModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserService implements UserServiceInterface {

    private final UserRepositoryInterface userRepositoryInterface;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepositoryInterface userRepositoryInterface) {
        super();
        this.userRepositoryInterface = userRepositoryInterface;
    }

    @Override
    public User save(UserRegistrationModel registrationModel) {
        User user = new User(registrationModel.getUsername(),
                registrationModel.getEmail(),
                passwordEncoder.encode(registrationModel.getPassword()), "ROLE_USER", true);

        return userRepositoryInterface.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepositoryInterface.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(), mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(String roles) {
        return Collections.singleton(new SimpleGrantedAuthority(roles));

    }
}
