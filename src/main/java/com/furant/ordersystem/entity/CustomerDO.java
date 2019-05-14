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
@TableName("customer")
public class CustomerDO implements java.io.Serializable {
    /**
     * 顾客id
     */
    @ApiModelProperty(value = "顾客id")
    @TableId
    private Integer id;
    /**
     * 顾客姓名
     */
    @ApiModelProperty(value = "顾客姓名")
    @TableField("customer_name")
    private String customerName;


    /**
     * 顾客密码
     */
    @ApiModelProperty(value = "顾客密码")
    @TableField("customer_password")
    private String customerPassword;


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
    @TableField
    private java.util.Date createtime;


    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @TableField
    private java.util.Date updatetime;
}

