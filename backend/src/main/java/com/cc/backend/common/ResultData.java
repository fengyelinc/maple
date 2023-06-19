package com.cc.backend.common;

import com.cc.backend.common.Eume.StatusCode;
import lombok.Data;

import java.util.Map;

@Data
public class ResultData {

    private String code;
    private String msg;
    private Map<String,Object> data;


    public ResultData() {

    }

    public ResultData(String success) {
        if(success.equals("success")){
            this.code = StatusCode.SUCCESS.getCode();
            this.msg = StatusCode.SUCCESS.getMsg();
        }else{
            this.code = StatusCode.FAIL.getCode();
            this.msg = StatusCode.FAIL.getMsg();
        }
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
