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

    private String name;

    private Long parentId;

    /**
     * 排序位置
     */
    @ApiModelProperty(value = "排序位置")
    private Long position;

    private String icon;

    private String url;

    private Long rid;

    private Date createdAt;

    private Date updatedAt;

}

