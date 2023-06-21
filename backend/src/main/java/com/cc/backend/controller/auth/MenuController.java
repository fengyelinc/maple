package com.cc.backend.controller.auth;


import com.cc.backend.common.ResultData;
import com.cc.backend.dao.vo.MenuTreeVO;
import com.cc.backend.service.MenuService;
import com.cc.backend.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/menu")
public class MenuController {


    @Autowired
    private MenuService menuService;
    @Autowired
    private SysUserService sysUserService;

    @GetMapping("list/{uid}")
    public ResultData getList(@PathVariable Long uid){
        Long roleId = sysUserService.getRoleId(uid);
        List<MenuTreeVO> list = menuService.getListByRid(roleId);
        ResultData resultData = new ResultData();
        HashMap<String, Object> map = new HashMap<>();
        map.put("menuList",list);
        resultData.setData(map);
        return resultData;
    }


}


