package com.cxx.server.vo;

import lombok.Data;

@Data
public class SourceVO {
    private Long id;

    private String name;

    private String projectId;

    private String type;

    private String connStr;

    private String note;
}
