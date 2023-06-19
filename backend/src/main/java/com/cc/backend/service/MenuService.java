package com.cc.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.backend.dao.entity.Menu;
import com.cc.backend.dao.vo.MenuTree;

import java.util.List;
import java.util.Map;

public interface MenuService extends IService<Menu> {

    List<MenuTree>  getListByRid(Long roleId);
}

