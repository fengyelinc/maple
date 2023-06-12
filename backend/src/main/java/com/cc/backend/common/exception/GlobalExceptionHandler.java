package com.cc.backend.common.exception;

import cn.hutool.extra.validation.BeanValidationResult;
import com.cc.backend.common.Eume.StatusCode;
import com.cc.backend.common.ResultData;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 参数异常的处理
     * @param ex
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResultData handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        // 获取错误信息
        BindingResult result = ex.getBindingResult();
        BeanValidationResult.ErrorMessage errorMessage = new BeanValidationResult.ErrorMessage();
        ResultData resultData = new ResultData();
        resultData.setCode(StatusCode.METHOD_ARGUMENT_NOT_VALID.getCode());
        resultData.setMsg(result.getFieldError().getDefaultMessage());
        return resultData;
    }
}
