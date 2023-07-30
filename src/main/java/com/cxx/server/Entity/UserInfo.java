package com.cxx.server.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class UserInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_info_id_seq")
    private Long id;

    private String userName;

    private String passWord;

    private String nickName;
}
