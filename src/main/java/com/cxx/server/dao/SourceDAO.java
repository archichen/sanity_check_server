package com.cxx.server.dao;

import com.cxx.server.Entity.Rule;
import com.cxx.server.Entity.Source;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SourceDAO extends JpaRepository<Source, Long> {
}
