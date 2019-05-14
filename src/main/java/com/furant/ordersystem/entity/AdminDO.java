package com.furant.ordersystem.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 代码自动生成，请不要修改，切记！！！
 */
@Data
@TableName("admin")
public class AdminDO implements java.io.Serializable {
    /**
     * 管理员id
     */
    @ApiModelProperty(value = "管理员id")
    @TableId
    private Integer id;


    /**
     * 管理员姓名
     */
    @TableField("admin_name")
    @ApiModelProperty(value = "管理员姓名")
    private String adminName;


    /**
     * 管理员密码
     */
    @ApiModelProperty(value = "管理员密码")
    @TableField("admin_password")
    private String adminPassword;


    /**
     * 是否被移除
     */
    @ApiModelProperty(value = "是否被移除")
    @TableField("is_deleted")
    private Integer isDeleted;


    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField("createtime")
    private java.util.Date createtime;


    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @TableField("updatetime")
    private java.util.Date updatetime;
}

