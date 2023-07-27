package com.cxx.server.controller;

import com.cxx.server.dto.ResponseDTO;
import com.cxx.server.dto.RuleDTO;
import com.cxx.server.dto.SourceDTO;
import com.cxx.server.vo.RuleVO;
import com.cxx.server.vo.SourceVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "SourceController", description = "数据源管理")
@RestController
@RequestMapping("/api/v1/source")
public class SourceController {
    @GetMapping("/list/{project_id}")
    @ResponseBody
    @Operation(summary = "获取数据源列表", description = "获取数据源列表", responses = {
            @ApiResponse(responseCode = "200", description = "获取数据源列表成功"),
            @ApiResponse(responseCode = "500", description = "获取数据源列表失败")
    }, parameters = {
            @Parameter(name = "project_id", description = "项目ID", required = true)
    })
    public ResponseDTO<List<SourceVO>> list(@PathVariable("project_id") Long projectId) {
        return null;
    }

    @Operation(summary = "获取数据源信息", description = "获取数据源",responses = {
            @ApiResponse(responseCode = "200", description = "获取数据源成功"),
            @ApiResponse(responseCode = "500", description = "获取数据源失败")
    },  parameters = {
            @Parameter(name = "source_id", description = "数据源ID", required = true)
    })
    @GetMapping("/get/{source_id}")
    @ResponseBody
    public ResponseDTO<SourceVO> get(@PathVariable("source_id") Long sourceId) {
        return null;
    }

    @Operation(summary = "创建数据源", description = "创建数据源", responses = {
            @ApiResponse(responseCode = "200", description = "创建数据源成功"),
            @ApiResponse(responseCode = "500", description = "创建数据源失败")
    }, requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "数据源信息", required = true, content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = SourceDTO.class))))
    @PostMapping("/create")
    @ResponseBody
    public ResponseDTO<SourceVO> create(@RequestBody SourceDTO sourceDTO) {
        return null;
    }

    @Operation(summary = "删除数据源", description = "删除数据源", responses = {
            @ApiResponse(responseCode = "200", description = "删除数据源成功"),
            @ApiResponse(responseCode = "500", description = "删除数据源失败")
    }, parameters = {
        @Parameter(name = "source_id", description = "数据源ID", required = true)
    })
    @PostMapping("/delete/{source_id}")
    @ResponseBody
    public ResponseDTO<SourceVO> delete(@PathVariable("source_id") Long sourceId) {
        return null;
    }

    @Operation(summary = "更新数据源", description = "更新数据源", responses = {
            @ApiResponse(responseCode = "200", description = "更新数据源成功"),
            @ApiResponse(responseCode = "500", description = "更新数据源失败")
    }, parameters = {
        @Parameter(name = "source_id", description = "数据源ID", required = true)
    })
    @PostMapping("/update/{source_id}")
    @ResponseBody
    public ResponseDTO<SourceVO> update(@PathVariable("source_id") Long sourceId) {
        return null;
    }
}
