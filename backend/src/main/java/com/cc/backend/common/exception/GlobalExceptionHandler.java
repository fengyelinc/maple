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

    /**
     * 这个不能定义在切面里面，不然不生效
     * @param e
     * @return
     */
    @ExceptionHandler(RuntimeException.class)
    public ResultData handle(RuntimeException e) {
        if ("notLogin".equals(e.getMessage())) {
            ResultData resultData = new ResultData(StatusCode.NO_AUTH.getCode(),StatusCode.NO_AUTH.getMsg());
            return resultData;
        }
        ResultData data = new ResultData(StatusCode.FAIL.getCode(), e.getMessage());
        return data;
    }
}
