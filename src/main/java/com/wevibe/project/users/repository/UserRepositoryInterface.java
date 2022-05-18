package com.wevibe.project.users.repository;

import com.wevibe.project.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepositoryInterface extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
