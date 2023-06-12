package com.cc.backend.controller;

import com.cc.backend.common.ResultData;
import com.cc.backend.dao.dto.LoginInfoDTO;
import com.cc.backend.dao.dto.RegisterInfoDTO;
import com.cc.backend.service.LoginService;
import com.cc.backend.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
public class LoginController {

    @Autowired
    public LoginService loginService;

    @Autowired
    public SysUserService sysUserService;


    /**
     * 注册
     * @param registerInfoDTO
     * @return
     */
    @PostMapping("/register")
    public ResultData register(@RequestBody @Valid RegisterInfoDTO registerInfoDTO) {
        ResultData resultData = new ResultData();
        //1.1、根据规则校验注册信息
        //1.2、根据规则校验注册信息是否有违禁词 TODO 添加违禁词表
        //2、校验是否已注册
        //3、注册账户
        //4、生成token
        return resultData;
    }


    /**
     * 账号密码登录
     * @param loginInfoDTO
     * @return
     */
    @PostMapping("/login")
    public ResultData login(@RequestBody LoginInfoDTO loginInfoDTO) {
        ResultData resultData = new ResultData();
        //1、判断是否有token
        //2、校验token是否失效
        //3、校验密码
        //4、获取身份信息(基础信息，权限)

        return resultData;
    }

}
