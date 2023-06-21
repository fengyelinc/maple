package com.cc.backend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cc.backend.dao.entity.Menu;
import com.cc.backend.dao.vo.MenuTreeVO;

import java.util.List;

public interface MenuService extends IService<Menu> {

    List<MenuTreeVO>  getListByRid(Long roleId);
}

