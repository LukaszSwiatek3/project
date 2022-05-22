package com.wevibe.project.tags;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepositoryInterface extends JpaRepository<Tag, Long> {

}
