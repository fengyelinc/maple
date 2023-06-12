package com.cc.backend.common.Eume;

public enum StatusCode {
    SUCCESS("200","success"),
    FAIL("500","fail"),
    METHOD_ARGUMENT_NOT_VALID("100001","参数异常"),
    NOT_FOUND("100002","资源未找到");

    public String code;
    public String msg;

    StatusCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
