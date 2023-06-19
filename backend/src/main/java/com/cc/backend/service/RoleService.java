package com.cc.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.backend.dao.dto.RoleDTO;
import com.cc.backend.dao.entity.Role;

public interface RoleService extends IService<Role> {

    boolean add(RoleDTO roleDTO);
}

