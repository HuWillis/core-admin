package com.example.core.admin.domain.dto.user;


import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "SysUserDTO - 用户信息数据传输对象")
public class SysUserDTO {

    @Schema(description = "用户ID", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private String userId;

    @Schema(description = "用户名", example = "admin", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "用户名不能为空")
    @Size(max = 30, message = "用户名长度不能超过30字符")
    private String username;

    @Schema(description = "用户昵称", example = "Administrator", requiredMode = Schema.RequiredMode.REQUIRED)
    @NotBlank(message = "用户昵称不能为空")
    @Size(max = 30, message = "用户昵称长度不能超过30字符")
    private String nickname;

    @Schema(description = "用户邮箱", example = "admin@example.com")
    @Email(message = "邮箱格式不正确")
    @Size(max = 50, message = "邮箱长度不能超过50字符")
    private String email;

    @Schema(description = "手机号码", example = "13800138000")
    @Pattern(regexp = "^\\d{11}$", message = "手机号码格式不正确")
    private String mobile;

    @Schema(description = "用户性别", example = "0", allowableValues = "0, 1")
    private Integer sex;

    @Schema(description = "帐号状态", example = "0", allowableValues = "0, 1")
    private Integer status;

    @Schema(description = "最后登录时间")
    private Date loginDate;
}

