package com.cc.backend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cc.backend.common.utils.BeanConvertUtils;
import com.cc.backend.dao.dto.RoleDTO;
import com.cc.backend.dao.entity.Role;
import com.cc.backend.mapper.RoleMapper;
import com.cc.backend.service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public boolean add(RoleDTO roleDTO) {
        Role role = BeanConvertUtils.convertBean(roleDTO, Role.class);
        int i = roleMapper.insert(role);
        return i>0?true:false;
    }


}

