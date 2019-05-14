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
@TableName("tables")
public class TablesDO implements java.io.Serializable {
    /**
     * 桌台id
     */
    @ApiModelProperty(value = "桌台id")
    @TableId
    private Integer id;

    /**
     * 桌台号码
     */
    @ApiModelProperty(value = "桌台号码")
    @TableField
    private Integer tablesNum;


    /**
     * 桌台状态，0代表空闲，其他代表有客人
     */
    @ApiModelProperty(value = "桌台状态，0代表空闲，其他代表有客人")
    @TableField
    private Integer tablesStatus;


    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    @TableField
    private String tablesRemark;


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
    private Date createtime;


    /**
     * 更新时间
     */
    @ApiModelProperty(value = "更新时间")
    @TableField
    private Date updatetime;
}

