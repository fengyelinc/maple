package com.cc.backend.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import lombok.Data;


@Data
public class Permission {


    @TableId(type = IdType.AUTO)
    private Long id;

    private String name;

}

