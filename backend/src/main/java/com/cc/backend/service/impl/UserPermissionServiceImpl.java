package com.cc.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.backend.dao.entity.UserPermission;
import com.cc.backend.mapper.UserPermissionMapper;
import com.cc.backend.service.UserPermissionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Service
public class UserPermissionServiceImpl extends ServiceImpl<UserPermissionMapper, UserPermission> implements UserPermissionService {
    @Autowired
    private UserPermissionMapper userPermissionMapper;
}

