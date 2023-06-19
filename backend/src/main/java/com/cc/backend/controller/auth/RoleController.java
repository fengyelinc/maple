package com.cc.backend.controller.auth;

import com.cc.backend.common.ResultData;
import com.cc.backend.dao.dto.RoleDTO;
import com.cc.backend.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("role")
public class RoleController {

    @Autowired
    private RoleService roleServicer;

    @PostMapping("add")
    public ResultData add(@RequestBody RoleDTO roleDTO){
       boolean b =  roleServicer.add(roleDTO);
       return b?new ResultData("success"):new ResultData("fail");
    }

}
