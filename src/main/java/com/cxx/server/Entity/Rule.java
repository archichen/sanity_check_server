package com.cxx.server.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

// 可以通过user_id和project_id来定位到某一条rule
@Entity
@Data
public class Rule {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rule_id_seq")
    private Long id;

    private Long projectId;

    private Long userId;

    private boolean isEnable;

    private String name;

    private Long sourceId;

    private String tableName;

    private String granularity = "Field";

    private String rule_type;

    private String param;

    private String period;

    private String note;
}
