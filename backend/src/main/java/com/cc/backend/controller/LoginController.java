package com.cc.backend.controller;

import com.cc.backend.common.Eume.StatusCode;
import com.cc.backend.common.ResultData;
import com.cc.backend.common.utils.BeanConvertUtils;
import com.cc.backend.common.utils.JwtUtils;
import com.cc.backend.common.utils.RedisUtil;
import com.cc.backend.dao.entity.SysUser;
import com.cc.backend.dao.dto.LoginInfoDTO;
import com.cc.backend.dao.dto.RegisterInfoDTO;
import com.cc.backend.service.LoginService;
import com.cc.backend.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Objects;


@RestController
public class LoginController {

    @Autowired
    public LoginService loginService;

    @Autowired
    public SysUserService sysUserService;

    @Autowired
    public RedisUtil redisUtil;


    /**
     * 注册
     *
     * @param registerInfoDTO
     * @return
     */
    @PostMapping("/register")
    public ResultData register(@RequestBody @Valid RegisterInfoDTO registerInfoDTO) {
        ResultData resultData = new ResultData();
        //1.1、根据规则校验注册信息
        //1.2、根据规则校验注册信息是否有违禁词 TODO 添加违禁词表
        //2、校验是否已注册
        SysUser user = sysUserService.getByEmailOrPhone(registerInfoDTO.getEmail(), registerInfoDTO.getPhone());
        if (Objects.nonNull(user)) {
            resultData.setMsg("该用户已注册！");
            return resultData;
        }
        //3、注册账户
        SysUser sysUser = BeanConvertUtils.convertBean(registerInfoDTO, SysUser.class);
        sysUser = sysUserService.register(sysUser);

        //4、生成token
        String token = generToken(sysUser);
        HashMap<String, Object> map = new HashMap<>();
        map.put("token", token);
        map.put("userInfo", sysUser);
        resultData.setCode(StatusCode.SUCCESS.getCode());
        resultData.setMsg(StatusCode.SUCCESS.getMsg());
        resultData.setData(map);
        return resultData;
    }


    /**
     * 账号密码登录
     *
     * @param loginInfoDTO
     * @return
     */
    @PostMapping("/login")
    public ResultData login(@RequestBody LoginInfoDTO loginInfoDTO) {
        ResultData resultData = new ResultData();
        //1、校验密码
        SysUser sysUser = sysUserService.getByAccount(loginInfoDTO.getAccount());
        if (!loginInfoDTO.getPassword().equals(sysUser.getPassword())){
            resultData.setCode(StatusCode.PASSWORD_WRONG.getCode());
            resultData.setMsg(StatusCode.PASSWORD_WRONG.getMsg());
            return resultData;
        }
        //2、获取身份信息(基础信息，权限) todo 权限设计
        //3、生成token
        generToken(sysUser);
        resultData.setCode(StatusCode.SUCCESS.getCode());
        resultData.setMsg(StatusCode.SUCCESS.getMsg());
        return resultData;
    }

    /**
     * 登出
     * @param uid
     * @return
     */
    @GetMapping("/logout/{uid}")
    public ResultData logout(@PathVariable("uid")Long uid){
        //清除token
        SysUser sysUser = sysUserService.getById(uid);
        redisUtil.del(sysUser.getEmail());
        return new ResultData("success");
    }

    /**
     * 生成token
     * @param sysUser
     */
    public String generToken(SysUser sysUser){
        String token = null;
        try {
            token = JwtUtils.generTokenByRS256(sysUser);
            redisUtil.set(sysUser.getEmail(), token, 3600);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return token;
    }

}
