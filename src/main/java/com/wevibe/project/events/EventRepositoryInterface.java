package com.wevibe.project.events;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepositoryInterface extends JpaRepository<Event,Long> {
}
