package com.github.cheese8.infra;

import java.io.Serializable;

public class Result<T> implements Serializable {
    private Integer code = ResultCode.SUCCESS.getCode();
    private String message;
    private T data;

    public Integer getCode() {
        return code;
    }

    public Result<T> code(Integer code) {
        this.code = code;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public Result<T> message(String message) {
        this.message = message;
        return this;
    }

    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.code(ResultCode.SUCCESS.getCode());
        result.message(ResultCode.SUCCESS.getMessage());
        return result;
    }

    public Result<T> custom(Integer code, String message) {
        this.code = code;
        this.message = message;
        return this;
    }

    public T getData() {
        return data;
    }

    public Result<T> data(T data) {
        this.data = data;
        return this;
    }
}