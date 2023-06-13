package com.cc.backend.common;

import com.cc.backend.common.Eume.StatusCode;
import lombok.Data;

import java.util.Map;

@Data
public class ResultData {

    public String code;
    public String msg;
    public Map<String,Object> data;


    public ResultData() {

    }

    public ResultData(String code, String msg, Map<String, Object> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultData(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultData(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.msg = statusCode.getMsg();
    }

}
