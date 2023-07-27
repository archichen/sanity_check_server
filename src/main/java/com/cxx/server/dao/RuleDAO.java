package com.cxx.server.dao;

import com.cxx.server.Entity.Project;
import com.cxx.server.Entity.Rule;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RuleDAO extends JpaRepository<Rule, Long> {
}
