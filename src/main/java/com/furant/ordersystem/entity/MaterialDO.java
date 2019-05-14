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
@TableName("material")
public class MaterialDO implements java.io.Serializable  {

    /**
     *食材id
     */
    @ApiModelProperty(value = "食材id")
    @TableId
    private Integer id;


    /**
     *食材名称
     */
    @ApiModelProperty(value = "食材名称")
    @TableField
    private String materialName;


    /**
     *库存
     */
    @ApiModelProperty(value = "库存")
    @TableField
    private Double materialRepertory;


    /**
     *备注
     */
    @ApiModelProperty(value = "备注")
    @TableField
    private String materialRemark;


    /**
     *是否删除
     */
    @ApiModelProperty(value = "是否删除")
    @TableField
    private Integer isDeleted;


    /**
     *创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @TableField
    private java.util.Date createtime;


    /**
     *更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @TableField
    private java.util.Date updatetime;
}

