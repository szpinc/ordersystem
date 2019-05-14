package com.furant.ordersystem.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 顾客登录
 */
@Data
@ApiModel("登录参数")
public class AdminLoginDTO {

    @ApiModelProperty(value = "用户名")
    private String userName;

    @ApiModelProperty(value = "密码")
    private String password;

}
