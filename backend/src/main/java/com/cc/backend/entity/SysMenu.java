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
@ApiModel("系统菜单")
public class SysMenu extends BaseEntity<SysMenu> {


    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 名称
     */
    @ApiModelProperty(value = "名称")
    private String menuName;

    /**
     * 类型 1：菜单  2：按钮
     */
    @ApiModelProperty(value = "类型 1：菜单  2：按钮")
    private String type;

    /**
     * 父级id （0为一级菜单）
     */
    @ApiModelProperty(value = "父级id （0为一级菜单）")
    private Integer parentId;

    /**
     * 菜单层级
     */
    @ApiModelProperty(value = "菜单层级")
    private Integer level;

    /**
     * 菜单图标
     */
    @ApiModelProperty(value = "菜单图标")
    private String icon;

    /**
     * 是否展示 0：否 1：是
     */
    @ApiModelProperty(value = "是否展示 0：否 1：是")
    private String isShow;

    /**
     * 排序
     */
    @ApiModelProperty(value = "排序")
    private Integer sort;



}

