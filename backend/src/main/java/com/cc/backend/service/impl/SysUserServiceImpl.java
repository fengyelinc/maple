package com.cc.backend.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.backend.common.Eume.RoleEume;
import com.cc.backend.dao.entity.Role;
import com.cc.backend.dao.entity.SysUser;
import com.cc.backend.dao.entity.UserPermission;
import com.cc.backend.dao.entity.UserRole;
import com.cc.backend.mapper.SysUserMapper;
import com.cc.backend.mapper.UserPermissionMapper;
import com.cc.backend.mapper.UserRoleMapper;
import com.cc.backend.service.SysUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;


@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    @Value("${permission.open}")
    private  Boolean permission;

    @Autowired
    private SysUserMapper sysUserMapper;

    @Autowired
    private UserPermissionMapper userPermissionMapper;

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public SysUser getByEmailOrPhone(String email,String phone) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("email",email).or().eq("phone",phone);
        SysUser one = sysUserMapper.selectOne(wrapper);
        return one;
    }

    @Override
    public SysUser getByAccount(String account) {
        QueryWrapper<SysUser> wrapper = new QueryWrapper<>();
        wrapper.eq("account",account);
        SysUser one = sysUserMapper.selectOne(wrapper);
        return one;
    }

    @Override
    public SysUser register(SysUser sysUser) {
        //1、插入用户表
        sysUser.setAccount(sysUser.getEmail());
        sysUserMapper.insert(sysUser);
        //2、生成角色
        generRole(sysUser.getId());
        //3、生成权限 权限放到开通vip那边
//        generPermission(sysUser.getId());

        return sysUser;
    }


    public void generRole(Long userId){
        //1、新用户默认普通用户角色
        UserRole userRole = new UserRole(RoleEume.USER);
        userRole.setUid(userId);
        userRoleMapper.insert(userRole);
    }

    /**
     * 根据具体业务自定义
     * @param userId
     */
    public void generPermission(Long userId){
        if(!permission){
            return;
        }
        // 下面的权限可自定义


    }


    @Override
    public Long getRoleId(Long uid) {
        UserRole userRole = userRoleMapper.selectOne(new LambdaQueryWrapper<UserRole>().eq(UserRole::getUid, uid));
        return userRole.getRid();
    }


}

