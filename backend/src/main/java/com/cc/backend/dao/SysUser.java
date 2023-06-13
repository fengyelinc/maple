package com.cc.backend.dao;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;


@Data
public class SysUser {


    @TableId(type = IdType.AUTO)
    private Long id;

    @TableField(value = "user_name")
    private String username;
    @TableField(value = "email")
    private String email;
    @TableField(value = "phone")
    private String phone;
    @TableField(value = "password")
    private String password;

}

