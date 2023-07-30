package com.cxx.server.vo;

import lombok.Data;

@Data
public class RuleVO {
    private Long id;

    private Long projectId;

    private Long userId;

    private boolean isEnable;

    private String name;

    private Long sourceId;

    private String tableName;

    private String granularity;

    private String rule_type;

    private String param;

    private String period;

    private String note;
}
