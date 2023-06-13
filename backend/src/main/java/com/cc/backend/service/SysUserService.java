package com.cc.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.backend.dao.SysUser;

public interface SysUserService extends IService<SysUser> {

     SysUser getByEmailOrPhone(String email,String phone);

}

