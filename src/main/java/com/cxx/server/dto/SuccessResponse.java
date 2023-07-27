package com.cxx.server.dto;

import com.cxx.server.consts.STATUS_CODE;

public class SuccessResponse<T> extends ResponseDTO<T> {
    public SuccessResponse() {
        super();
        this.setCode(STATUS_CODE.SUCCESS.getStatusCode());
        this.setMessage("success");
    }

    public SuccessResponse(T data) {
        super();
        this.setCode(STATUS_CODE.SUCCESS.getStatusCode());
        this.setMessage("success");
        this.setData(data);
    }
}
