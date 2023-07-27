package com.cxx.server.dto;

import com.cxx.server.consts.STATUS_CODE;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
@Schema(name = "ResponseDTO", description = "响应信息")
public class ResponseDTO<T> {
    @JsonProperty("code")
    @Schema(name = "code", description = "响应码")
    private int code;

    @JsonProperty("message")
    @Schema(name = "message", description = "响应信息")
    private String message;

    @JsonProperty("data")
    @Schema(name = "data", description = "响应数据")
    private T data;

    @JsonProperty("timestamp")
    @Schema(name = "timestamp", description = "响应时间")
    private Date timestamp = new Date();
}
