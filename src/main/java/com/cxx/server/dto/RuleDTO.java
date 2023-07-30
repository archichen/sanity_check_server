package com.cxx.server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "RuleDTO", description = "规则信息")
public class RuleDTO {
    @JsonProperty("id")
    @Schema(name = "id", description = "规则ID")
    private Long id;

    @JsonProperty("project_id")
    @Schema(name = "project_id", description = "项目ID")
    private Long projectId;

    @JsonProperty("user_id")
    @Schema(name = "user_id", description = "用户ID")
    private Long userId;

    @JsonProperty("is_enable")
    @Schema(name = "is_enable", description = "是否启用")
    private boolean isEnable;

    @JsonProperty("name")
    @Schema(name = "name", description = "规则名")
    private String name;

    @JsonProperty("source_id")
    @Schema(name = "source_id", description = "数据源ID")
    private Long sourceId;

    @JsonProperty("table_name")
    @Schema(name = "table_name", description = "表名")
    private String tableName;

    @JsonProperty("granularity")
    @Schema(name = "granularity", description = "规则粒度")
    private String granularity;

    @JsonProperty("rule_type")
    @Schema(name = "rule_type", description = "规则类型")
    private String rule_type;

    @JsonProperty("param")
    @Schema(name = "param", description = "规则参数")
    private String param;

    @JsonProperty("period")
    @Schema(name = "period", description = "运行周期间隔")
    private String period;

    @JsonProperty("note")
    @Schema(name = "note", description = "备注")
    private String note;
}
