package com.wevibe.project.users.userdetails;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailsRepositoryInterface extends JpaRepository<UserDetails,Long> {
}
