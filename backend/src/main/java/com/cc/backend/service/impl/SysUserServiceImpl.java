package com.cc.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.backend.dao.SysUser;
import com.cc.backend.mapper.SysUserMapper;
import com.cc.backend.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getByEmailOrPhone(String email,String phone) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("email",email).or().eq("phone",phone);
        SysUser one = sysUserMapper.selectOne(wrapper);
        return one;
    }
}

