package com.cxx.server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(name = "ProjectDTO", description = "项目信息")
public class ProjectDTO {
    @JsonProperty("project_name")
    @Schema(name = "project_name", description = "项目名")
    private String projectName;

    @JsonProperty("project_id")
    @Schema(name = "project_id", description = "项目ID")
    private Long projectId;

    @Schema(name = "note", description = "备注")
    private String note;
}
