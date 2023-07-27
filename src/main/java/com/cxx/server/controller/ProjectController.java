package com.cxx.server.controller;

import com.cxx.server.dto.ErrorResponse;
import com.cxx.server.dto.ProjectDTO;
import com.cxx.server.dto.ResponseDTO;
import com.cxx.server.dto.SuccessResponse;
import com.cxx.server.service.serviceImpl.ProjectServiceImpl;
import com.cxx.server.vo.ProjectVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "ProjectController", description = "项目管理")
@RestController
@RequestMapping("/api/v1/project")
public class ProjectController {
    @Autowired
    private ProjectServiceImpl projectService;

    @GetMapping("/list/{user_id}")
    @ResponseBody
    @Operation(summary = "获取项目列表", description = "获取项目列表", responses = {
            @ApiResponse(responseCode = "200", description = "获取项目列表成功"),
            @ApiResponse(responseCode = "500", description = "获取项目列表失败")
    }, parameters = {
            @Parameter(name = "user_id", description = "用户ID", required = true)
    })
    public ResponseDTO<List<ProjectVO>> list(@PathVariable("user_id") Long userId) {
        return projectService.getAll(userId);
    }

    @Operation(summary = "获取项目", description = "获取项目", responses = {
            @ApiResponse(responseCode = "200", description = "获取项目成功"),
            @ApiResponse(responseCode = "500", description = "获取项目失败")
    }, parameters = {
            @Parameter(name = "project_id", description = "项目ID", required = true)
    })
    @GetMapping("/get/{project_id}")
    @ResponseBody
    public ResponseDTO<ProjectVO> get(@PathVariable("project_id") Long projectId) {
        return projectService.get(projectId);
    }

    @Operation(summary = "创建项目", description = "创建项目", responses = {
            @ApiResponse(responseCode = "200", description = "创建项目成功"),
            @ApiResponse(responseCode = "500", description = "创建项目失败")
    }, requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "项目信息", required = true, content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ProjectDTO.class))))
    @PostMapping("/create")
    @ResponseBody
    public ResponseDTO<ProjectVO> create(@RequestBody ProjectDTO projectDTO) {
        return projectService.create(projectDTO);
    }

    @Operation(summary = "删除项目", description = "删除项目", responses = {
            @ApiResponse(responseCode = "200", description = "删除项目成功"),
            @ApiResponse(responseCode = "500", description = "删除项目失败")
    }, parameters = {
            @Parameter(name = "project_id", description = "项目ID", required = true)
    })
    @PostMapping("/delete/{project_id}")
    @ResponseBody
    public ResponseDTO<ProjectVO> delete(@PathVariable("project_id") Long projectId) {
        try {
            projectService.delete(projectId);
            return new SuccessResponse<>();
        } catch (Exception e) {
            return new ErrorResponse<>(e.getMessage());
        }
    }

    @Operation(summary = "更新项目", description = "更新项目", responses = {
            @ApiResponse(responseCode = "200", description = "更新项目成功"),
            @ApiResponse(responseCode = "500", description = "更新项目失败")
    }, requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "项目信息", required = true, content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = ProjectDTO.class)))
    )
    @PostMapping("/update")
    @ResponseBody
    public ResponseDTO<ProjectVO> update(@RequestBody ProjectDTO projectDTO) {
        return projectService.update(projectDTO);
    }
}
