package com.wevibe.project.opinions;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpinionRepositoryInterface extends JpaRepository<Opinion,Long> {
}
