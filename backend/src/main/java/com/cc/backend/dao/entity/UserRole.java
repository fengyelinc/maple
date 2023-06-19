package com.cc.backend.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.cc.backend.common.Eume.RoleEume;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@Data
public class UserRole {


    private Long uid;

    private Long rid;

    public UserRole() {
    }

    public UserRole(RoleEume P) {
        this.rid = P.USER.getId();
    }
}

