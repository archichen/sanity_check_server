package com.cxx.server.controller;

import com.cxx.server.dto.ResponseDTO;
import com.cxx.server.dto.UserInfoDTO;
import com.cxx.server.service.serviceImpl.UserInfoServiceImpl;
import com.cxx.server.vo.UserInfoVO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "UserInfoController", description = "用户管理")
@RestController
@RequestMapping("/api/v1/user")
public class UserInfoController {
    @Autowired
    UserInfoServiceImpl userInfoServiceImpl;

    @GetMapping("/list")
    @ResponseBody
    @Operation(summary = "获取用户列表", description = "获取用户列表", responses = {
            @ApiResponse(responseCode = "200", description = "获取用户列表成功"),
            @ApiResponse(responseCode = "500", description = "获取用户列表失败")
    })
    public ResponseDTO<List<UserInfoVO>> list() {
        return userInfoServiceImpl.getAll();
    }

    @Operation(summary = "获取用户信息", description = "获取用户",responses = {
            @ApiResponse(responseCode = "200", description = "获取用户成功"),
            @ApiResponse(responseCode = "500", description = "获取用户失败")
    },  parameters = {
            @Parameter(name = "user_id", description = "用户ID", required = true)
    })
    @GetMapping("/get/{user_id}")
    @ResponseBody
    public ResponseDTO<UserInfoVO> get(@PathVariable("user_id") Long userId) {
        return userInfoServiceImpl.get(userId);
    }

    @Operation(summary = "创建用户", description = "创建用户", responses = {
            @ApiResponse(responseCode = "200", description = "创建用户成功"),
            @ApiResponse(responseCode = "500", description = "创建用户失败")
    }, requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "用户信息", required = true, content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = UserInfoDTO.class))))
    @PostMapping("/create")
    @ResponseBody
    public ResponseDTO<UserInfoVO> create(@RequestBody UserInfoDTO userDTO) {
        return userInfoServiceImpl.create(userDTO);
    }

    @Operation(summary = "删除用户", description = "删除用户", responses = {
            @ApiResponse(responseCode = "200", description = "删除用户成功"),
            @ApiResponse(responseCode = "500", description = "删除用户失败")
    }, parameters = {
        @Parameter(name = "user_id", description = "用户ID", required = true)
    })
    @PostMapping("/delete/{user_id}")
    @ResponseBody
    public void delete(@PathVariable("user_id") Long userId) {
        userInfoServiceImpl.delete(userId);
    }

    @Operation(summary = "更新用户", description = "更新用户", responses = {
            @ApiResponse(responseCode = "200", description = "更新用户成功"),
            @ApiResponse(responseCode = "500", description = "更新用户失败")
    }, requestBody = @io.swagger.v3.oas.annotations.parameters.RequestBody(description = "用户信息", required = true, content = @io.swagger.v3.oas.annotations.media.Content(mediaType = "application/json", schema = @io.swagger.v3.oas.annotations.media.Schema(implementation = UserInfoDTO.class))))
    @PostMapping("/update")
    @ResponseBody
    public ResponseDTO<UserInfoVO> update(@RequestBody UserInfoDTO userInfoDTO) {
        return userInfoServiceImpl.update(userInfoDTO);
    }
}
