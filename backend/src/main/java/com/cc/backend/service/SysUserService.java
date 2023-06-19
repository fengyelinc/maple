package com.cc.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.backend.dao.entity.SysUser;

public interface SysUserService extends IService<SysUser> {

     SysUser getByEmailOrPhone(String email,String phone);

    SysUser getByAccount(String account);

    SysUser register(SysUser sysUser);
}

