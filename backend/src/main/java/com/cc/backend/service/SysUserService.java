package com.cc.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.backend.dao.SysUser;

public interface SysUserService extends IService<SysUser> {

    public SysUser getByEmail(String email);

}

