package com.example.core.admin.domain.vo.user;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

/**
 * @author hy
 * @title: SysUserVO
 * @projectName core-admin
 * @description: 用户信息VO (视图对象)
 * @date 2024-10-17 16:41:59 16:41
 */
@Data
@ApiModel(value = "SysUserVO", description = "用户信息视图对象")
public class SysUserVO {

    @ApiModelProperty(value = "用户ID", example = "1", required = true)
    private String userId;

    @ApiModelProperty(value = "用户名", example = "admin")
    private String username;

    @ApiModelProperty(value = "用户昵称", example = "Administrator")
    private String nickname;

    @ApiModelProperty(value = "用户邮箱", example = "admin@example.com")
    private String email;

    @ApiModelProperty(value = "手机号码", example = "13800138000")
    private String mobile;

    @ApiModelProperty(value = "用户性别", example = "0", allowableValues = "0, 1")
    private Integer sex;

    @ApiModelProperty(value = "头像地址", example = "/images/avatar.png")
    private String avatar;

    @ApiModelProperty(value = "帐号状态", example = "0", allowableValues = "0, 1")
    private Integer status;

    @ApiModelProperty(value = "最后登录时间")
    private Date loginDate;
}

