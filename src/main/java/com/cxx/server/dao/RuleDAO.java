package com.cxx.server.dao;

import com.cxx.server.Entity.Project;
import com.cxx.server.Entity.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RuleDAO extends JpaRepository<Rule, Long> {
    public List<Rule> findAllByUserIdAndProjectId(Long userId, Long projectId);
}
