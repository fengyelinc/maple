package com.cc.backend.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import com.cc.backend.base.BaseEntity;

import java.io.Serializable;
import java.util.Date;


@Data
@ApiModel("系统角色菜单表")
public class SysRoleMenu extends BaseEntity<SysRoleMenu> {


    private Integer roleId;

    private Integer menuId;

}

