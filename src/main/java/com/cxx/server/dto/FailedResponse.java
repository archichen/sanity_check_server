package com.cxx.server.dto;

import com.cxx.server.consts.STATUS_CODE;

public class FailedResponse<T> extends ResponseDTO<T> {
    public FailedResponse() {
        super();
        this.setCode(STATUS_CODE.FAIL.getStatusCode());
        this.setMessage("fail");
    }

    public FailedResponse(T data) {
        super();
        this.setCode(STATUS_CODE.FAIL.getStatusCode());
        this.setMessage("fail");
        this.setData(data);
    }

    public FailedResponse(String message) {
        super();
        this.setCode(STATUS_CODE.FAIL.getStatusCode());
        this.setMessage(message);
    }
}
