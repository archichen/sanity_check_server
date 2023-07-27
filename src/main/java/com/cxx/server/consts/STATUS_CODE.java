package com.cxx.server.consts;

import lombok.Getter;

@Getter
public enum STATUS_CODE {
    SUCCESS(0),
    FAIL(1),
    ERROR(2);

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    private int statusCode;

    STATUS_CODE(int statusCode) {
        this.statusCode = statusCode;
    }
}
