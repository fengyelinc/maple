package com.cc.backend.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
public class Menu {


    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 上级id
     */
    private Long parentId;

    /**
     * 排序位置
     */
    @ApiModelProperty(value = "排序位置")
    private Long position;

    /**
     * 图标
     */
    private String icon;

    /**
     * 菜单路由
     */
    private String url;

    /**
     * 角色id
     */
    private Long rid;

    /**
     * 创建时间
     */
    private Date createdAt;

    /**
     * 更新时间
     */
    private Date updatedAt;

    /**
     * 是否删除 1是 0否
     */
    private Integer isDel;

}

