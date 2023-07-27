package com.cxx.server.vo;

import lombok.Data;

import java.util.List;

@Data
public class UserInfoVO {
    private Long id;

    private String userName;

    private String passWord;

    private String nickName;

    private List<Long> projects;
}
