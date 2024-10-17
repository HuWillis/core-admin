package com.example.core.admin.domain.dto.user;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Data;

/**
 * @author hy
 * @title: SysUserDTO
 * @projectName core-admin
 * @description: 用户信息DTO (数据传输对象)
 * @date 2024-10-17 16:39:16 16:39
 */
@Data
@ApiModel(value = "SysUserDTO", description = "用户信息数据传输对象")
public class SysUserDTO {

    @ApiModelProperty(value = "用户ID", example = "1", required = true)
    private String userId;

    @ApiModelProperty(value = "用户名", example = "admin", required = true)
    @NotBlank(message = "用户名不能为空")
    @Size(max = 30, message = "用户名长度不能超过30字符")
    private String username;

    @ApiModelProperty(value = "用户昵称", example = "Administrator", required = true)
    @NotBlank(message = "用户昵称不能为空")
    @Size(max = 30, message = "用户昵称长度不能超过30字符")
    private String nickname;

    @ApiModelProperty(value = "用户邮箱", example = "admin@example.com")
    @Email(message = "邮箱格式不正确")
    @Size(max = 50, message = "邮箱长度不能超过50字符")
    private String email;

    @ApiModelProperty(value = "手机号码", example = "13800138000")
    @Pattern(regexp = "^\\d{11}$", message = "手机号码格式不正确")
    private String mobile;

    @ApiModelProperty(value = "用户性别", example = "0", allowableValues = "0, 1")
    private Integer sex;

    @ApiModelProperty(value = "帐号状态", example = "0", allowableValues = "0, 1")
    private Integer status;

    @ApiModelProperty(value = "最后登录时间")
    private Date loginDate;

    @ApiModelProperty(value = "创建时间")
    private Date createTime;

    @ApiModelProperty(value = "更新时间")
    private Date updateTime;

    @ApiModelProperty(value = "是否删除", example = "false")
    private Boolean deleted;

    @ApiModelProperty(value = "租户编号", example = "1001")
    private Long tenantId;
}

