package com.cxx.server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(name = "SourceDTO", description = "数据源信息")
public class SourceDTO {
    @JsonProperty("id")
    @Schema(name = "id", description = "数据源ID")
    private Long id;

    @JsonProperty("name")
    @Schema(name = "name", description = "数据源名")
    private String name;

    @JsonProperty("project_id")
    @Schema(name = "project_id", description = "项目ID")
    private String projectId;

    @JsonProperty("type")
    @Schema(name = "type", description = "数据源类型")
    private String type;

    @JsonProperty("conn_str")
    @Schema(name = "conn_str", description = "连接字符串")
    private String connStr;

    @JsonProperty("note")
    @Schema(name = "note", description = "备注")
    private String note;
}
