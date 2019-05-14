package com.furant.ordersystem.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;


/**
 * 代码自动生成，请不要修改，切记！！！
 */
@Data
@TableName("food")
public class FoodDO implements java.io.Serializable {
    /**
     * 主食id
     */
    @ApiModelProperty(value = "主食id")
    @TableId
    private Integer id;


    /**
     * 主食名字
     */
    @ApiModelProperty(value = "主食名字")
    @TableField("food_name")
    private String foodName;


    /**
     * 单价
     */
    @ApiModelProperty(value = "单价")
    @TableField("food_price")
    private Double foodPrice;


    /**
     * 描述
     */
    @ApiModelProperty(value = "描述")
    @TableField("food_describe")
    private String foodDescribe;


    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @TableField("food_remark")
    private String foodRemark;


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
    private Date createtime;


    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @TableField
    private Date updatetime;
}

