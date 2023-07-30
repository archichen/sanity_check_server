package com.cxx.server.dao;

import com.cxx.server.Entity.Project;
import com.cxx.server.Entity.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectDAO extends JpaRepository<Project, Long> {
    List<Project> findAllByUserId(Long userId);
    boolean existsByUserIdAndProjectName(Long userId, String projectName);
}
