package com.cxx.server.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.List;

@Data
@Schema(name = "UserInfoDTO", description = "用户信息")
public class UserInfoDTO {
    @JsonProperty("id")
    @Schema(name = "id", description = "用户ID")
    private Long id;

    @JsonProperty("user_name")
    @Schema(name = "user_name", description = "用户名")
    private String userName;

    @JsonProperty("pass_word")
    @Schema(name = "pass_word", description = "密码")
    private String passWord;

    @JsonProperty("nick_name")
    @Schema(name = "nick_name", description = "昵称")
    private String nickName;
}
