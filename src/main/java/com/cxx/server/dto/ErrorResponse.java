package com.cxx.server.dto;

import com.cxx.server.consts.STATUS_CODE;

public class ErrorResponse<T> extends ResponseDTO<T> {
    public ErrorResponse() {
        super();
        this.setCode(STATUS_CODE.ERROR.getStatusCode());
        this.setMessage("");
    }

    public ErrorResponse(T data) {
        super();
        this.setCode(STATUS_CODE.ERROR.getStatusCode());
        this.setMessage("");
        this.setData(data);
    }

    public ErrorResponse(String message) {
        super();
        this.setCode(STATUS_CODE.ERROR.getStatusCode());
        this.setMessage(message);
    }
}
