package com.cxx.server.dao;

import com.cxx.server.Entity.Rule;
import com.cxx.server.Entity.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserInfoDAO extends JpaRepository<UserInfo, Long> {
    boolean existsByUserName(String userName);
}
