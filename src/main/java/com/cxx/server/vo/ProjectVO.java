package com.cxx.server.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Schema(name = "ProjectVO", description = "项目信息")
public class ProjectVO {
    @Schema(name = "project_name", description = "项目名")
    private String projectName;

    @Schema(name = "project_id", description = "项目ID")
    private Long projectId;

    @Schema(name = "user_id", description = "用户ID")
    private Long userId;

    @Schema(name = "note", description = "备注")
    private String note;
}
