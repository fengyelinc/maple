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
@ApiModel("用户角色关联表")
public class SysUserRole extends BaseEntity<SysUserRole> {


    /**
     * user表id
     */
    @ApiModelProperty(value = "user表id")
    private Long userId;

    /**
     * role表id
     */
    @ApiModelProperty(value = "role表id")
    private Integer roleId;

}

