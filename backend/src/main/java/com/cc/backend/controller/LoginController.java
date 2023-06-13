package com.cc.backend.controller;

import com.cc.backend.common.Eume.StatusCode;
import com.cc.backend.common.ResultData;
import com.cc.backend.common.utils.BeanConvertUtils;
import com.cc.backend.common.utils.JwtUtils;
import com.cc.backend.common.utils.RedisUtil;
import com.cc.backend.dao.SysUser;
import com.cc.backend.dao.dto.LoginInfoDTO;
import com.cc.backend.dao.dto.RegisterInfoDTO;
import com.cc.backend.service.LoginService;
import com.cc.backend.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
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
     * @param registerInfoDTO
     * @return
     */
    @PostMapping("/register")
    public ResultData register(@RequestBody @Valid RegisterInfoDTO registerInfoDTO) {
        ResultData resultData = new ResultData();
        //1.1、根据规则校验注册信息
        //1.2、根据规则校验注册信息是否有违禁词 TODO 添加违禁词表
        //2、校验是否已注册
        SysUser user = sysUserService.getByEmailOrPhone(registerInfoDTO.getEmail(),registerInfoDTO.getPhone());
        if(Objects.nonNull(user)){
            resultData.setMsg("该用户已注册！");
            return resultData;
        }
        //3、注册账户
        SysUser sysUser = BeanConvertUtils.convertBean(registerInfoDTO, SysUser.class);
        sysUserService.save(sysUser);
        //4、生成token
        String token =null;
        try {
             token = JwtUtils.generTokenByRS256(sysUser);
            redisUtil.set(sysUser.getId()+sysUser.getEmail(),token,3600);
        } catch (Exception e) {
            e.printStackTrace();
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("token",token);
        map.put("userInfo",sysUser);
        resultData.setCode(StatusCode.SUCCESS.getCode());
        resultData.setMsg(StatusCode.SUCCESS.getMsg());
        resultData.setData(map);
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
