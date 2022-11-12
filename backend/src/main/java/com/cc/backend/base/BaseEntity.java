package com.cc.backend.base;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import java.util.Date;

@Data
public abstract class BaseEntity<T extends Model<?>> extends Model<T>  {



    /**
     *  创建者
     */
    @TableField(value = "creatBy", fill = FieldFill.INSERT)
    protected String creatBy;


    /**
     * 创建日期
     */
    @TableField(value = "createTime", fill = FieldFill.INSERT)
    protected Date createTime;

    /**
     * 更新者
     */
    @TableField(value = "updateBy", fill = FieldFill.INSERT_UPDATE)
    protected String updateBy;

    /**
     * 更新日期
     */
    @TableField(value = "updateTime", fill = FieldFill.INSERT_UPDATE)
    protected Date updateTime;



    /**
     * 逻辑删除（0:否 1：是）
     */
    @TableField(value = "isDel")
    protected String isDel;



}
