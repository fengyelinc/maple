package com.cc.backend.controller.auth;

import com.cc.backend.dao.SysUser;
import com.cc.backend.service.SysUserService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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


}