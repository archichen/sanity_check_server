package com.cxx.server.controller;

import com.cxx.server.dto.ResponseDTO;
import com.cxx.server.dto.RuleDTO;
import com.cxx.server.vo.RuleVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "RuleController", description = "规则管理")
@RestController
@RequestMapping("/api/v1/rule")
public class RuleController {
    @GetMapping("/list/{user_id}/{project_id}")
    @ResponseBody
    @Operation(summary = "获取规则列表", description = "获取规则列表", responses = {
            @ApiResponse(responseCode = "200", description = "获取规则列表成功"),
            @ApiResponse(responseCode = "500", description = "获取规则列表失败")
    }, parameters = {
            @Parameter(name = "user_id", description = "用户ID", required = true),
            @Parameter(name = "project_id", description = "项目ID", required = true)
    })
    public ResponseDTO<List<RuleVO>> list(@PathVariable("user_id") Long userId, @PathVariable("project_id") Long projectId) {
        return null;
    }

    @Operation(summary = "获取规则信息", description = "通过规则Id获取规则信息",responses = {
            @ApiResponse(responseCode = "200", description = "获取规则信息成功"),
            @ApiResponse(responseCode = "500", description = "获取规则信息失败")
    },  parameters = {
            @Parameter(name = "rule_id", description = "规则ID", required = true)
    })
    @GetMapping("/get/{rule_id}")
    @ResponseBody
    public ResponseDTO<RuleVO> get(@PathVariable("rule_id") Long RuleId) {
        return null;
    }

    @Operation(summary = "创建规则", description = "创建规则", responses = {
            @ApiResponse(responseCode = "200", description = "创建规则成功"),
            @ApiResponse(responseCode = "500", description = "创建规则失败")
    }, requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "规则信息", required = true, content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = RuleDTO.class))))
    @PostMapping("/create")
    @ResponseBody
    public ResponseDTO<RuleVO> create(@RequestBody RuleDTO ruleDTO) {
        return null;
    }

    @Operation(summary = "删除规则", description = "删除规则", responses = {
            @ApiResponse(responseCode = "200", description = "删除规则成功"),
            @ApiResponse(responseCode = "500", description = "删除规则失败")
    }, parameters = {
        @Parameter(name = "rule_id", description = "规则ID", required = true)
    })
    @PostMapping("/delete/{rule_id}")
    @ResponseBody
    public ResponseDTO<RuleVO> delete(@PathVariable("rule_id") Long rule_id) {
        return null;
    }

    @Operation(summary = "更新规则", description = "更新规则", responses = {
            @ApiResponse(responseCode = "200", description = "更新规则成功"),
            @ApiResponse(responseCode = "500", description = "更新规则失败")
    }, parameters = {
        @Parameter(name = "rule_id", description = "规则ID", required = true)
    })
    @PostMapping("/update/{rule_id}")
    @ResponseBody
    public ResponseDTO<RuleVO> update(@PathVariable("rule_id") Long ruleId) {
        return null;
    }
}
