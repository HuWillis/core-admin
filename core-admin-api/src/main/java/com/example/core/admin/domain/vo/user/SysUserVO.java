package com.example.core.admin.domain.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
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
@Schema(description = "SysUserVO - 用户信息视图对象")
public class SysUserVO {

    @Schema(description = "用户ID", example = "1", requiredMode = Schema.RequiredMode.REQUIRED)
    private String userId;

    @Schema(description = "用户名", example = "admin")
    private String username;

    @Schema(description = "用户昵称", example = "Administrator")
    private String nickname;

    @Schema(description = "用户邮箱", example = "admin@example.com")
    private String email;

    @Schema(description = "手机号码", example = "13800138000")
    private String mobile;

    @Schema(description = "用户性别", example = "0", allowableValues = "0, 1")
    private Integer sex;

    @Schema(description = "头像地址", example = "/images/avatar.png")
    private String avatar;

    @Schema(description = "帐号状态", example = "0", allowableValues = "0, 1")
    private Integer status;

    @Schema(description = "最后登录时间")
    private Date loginDate;
}

