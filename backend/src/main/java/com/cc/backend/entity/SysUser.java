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
@ApiModel("系统用户表")
public class SysUser extends BaseEntity<SysUser> {


    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String name;

    /**
     * 账号
     */
    @ApiModelProperty(value = "账号")
    private String account;

    /**
     * 手机号
     */
    @ApiModelProperty(value = "手机号")
    private String phone;

    /**
     * 邮箱
     */
    @ApiModelProperty(value = "邮箱")
    private String email;

    /**
     * 0：女 1：男 2：其他
     */
    @ApiModelProperty(value = "0：女 1：男 2：其他")
    private String sex;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码")
    private String password;

    /**
     * 是否冻结  0:否 1：是
     */
    @ApiModelProperty(value = "是否冻结  0:否 1：是")
    private String isFrozen;


}

