package com.cc.backend.controller.auth;

import com.cc.backend.dao.entity.SysUser;
import com.cc.backend.service.SysUserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/sysUsers")
public class SysUserController {

    @Autowired
    private SysUserService sysUserService;

    @GetMapping("/{id}")
    public SysUser getUser(@PathVariable("id") Long id) {
        SysUser sysUser = sysUserService.getById(id);
        return sysUser;
    }


    @PostMapping("/edit")
    public SysUser edit(@RequestBody SysUser sysUser) {
        SysUser user = sysUserService.getById(sysUser.getId());
        user.setCreateTime(LocalDateTime.now());
        sysUserService.updateById(user);
        return user;
    }


}