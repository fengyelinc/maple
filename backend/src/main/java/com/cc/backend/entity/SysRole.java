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
@ApiModel("系统角色表")
public class SysRole extends BaseEntity<SysRole> {


    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 角色名称
     */
    @ApiModelProperty(value = "角色名称")
    private String roleName;

    /**
     * 权限范围 1：个人权限 2：部门权限 3：全局权限
     */
    @ApiModelProperty(value = "权限范围 1：个人权限 2：部门权限 3：全局权限")
    private String scope;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remark;


}

