package com.cc.backend.controller;

import com.cc.backend.entity.SysUser;
import com.cc.backend.service.SysUserService;


import io.swagger.annotations.ApiOperation;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.api.R;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/sysUser")
public class SysUserController {

    /**
     * �������
     */
    @Autowired
    private SysUserService sysUserService;


}


