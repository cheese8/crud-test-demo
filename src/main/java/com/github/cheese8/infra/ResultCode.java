package com.github.cheese8.infra;

import java.util.Map;
import java.util.TreeMap;

public enum ResultCode {
    // @formatter:off
    SUCCESS(200, "SUCCESS"),
    ERROR(999, "ERROR");
    // @formatter:on
    private final static Map<Integer, ResultCode> map = new TreeMap<>();
    static {
        for (ResultCode resultCode : ResultCode.values()) {
            map.put(resultCode.getCode(), resultCode);
        }
    }

    private final Integer code;
    private final String message;

    private ResultCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}