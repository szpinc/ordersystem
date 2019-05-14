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
@TableName("drink")
public class DrinkDO implements java.io.Serializable {

    /**
     * 饮品id
     */
    @ApiModelProperty(value = "饮品id")
    @TableId
    private Integer id;


    /**
     * 饮品名字
     */
    @ApiModelProperty(value = "饮品名字")
    @TableField("drink_name")
    private String drinkName;


    /**
     * 单价
     */
    @ApiModelProperty(value = "单价")
    @TableField("drink_price")
    private Double drinkPrice;


    /**
     * 甜度，1-10分别代表不同的甜度
     */
    @ApiModelProperty(value = "甜度，1-10分别代表不同的甜度")
    @TableField("drink_sweetness")
    private Integer drinkSweetness;


    /**
     * 是否被删除
     */
    @ApiModelProperty(value = "是否被删除")
    @TableField
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
    private java.util.Date updatetime;
}

