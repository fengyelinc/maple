package com.cc.backend.common.aspect;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.cc.backend.common.Eume.StatusCode;
import com.cc.backend.common.ResultData;
import com.cc.backend.common.utils.JwtUtils;
import com.cc.backend.common.utils.RedisUtil;
import com.cc.backend.dao.entity.SysUser;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class AuthAspect {
    @Autowired
    public RedisUtil redisUtil;

    private ResultData resultData = new ResultData(StatusCode.NO_AUTH.getCode(),StatusCode.NO_AUTH.getMsg());

    /**
     * 切面校验是否包含token
     * auth包下的接口需要登录才能访问
     * @throws IOException
     */
    @Before("execution(* com.cc.backend.controller.auth.*.*(..))")
    public void checkAuth(JoinPoint joinPoint) {
        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = sra.getRequest();
        HttpServletResponse response = sra.getResponse();
        String token = request.getHeader("token");
        System.out.println("token: "+token);
        if (token == null) {
//            response.sendRedirect("/login");
            System.out.println("没有权限访问"+request.getRequestURL());
            throw new RuntimeException("notLogin");
        }
        if(!token.equals("666")) {
            SysUser userInfo = null;
            try {
                userInfo = JwtUtils.getUserInfo(token);
            } catch (Exception e) {
                throw new RuntimeException("token error");
            }
            String code = (String) redisUtil.get(userInfo.getEmail());
            if (!token.equals(code)) {
                System.out.println("token 验证错误");
                throw new RuntimeException("token error");
            }
        }
    }




}