package com.example.core.admin.domain.dto.user;

import com.example.core.admin.common.po.PageParam;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author hy
 * @title: SysUserPageDTO
 * @projectName core-admin
 * @description: TODO
 * @date 2024-10-21 14:36:59 14:36
 */
@Data
@Schema(description = "SysUserPageDTO - 用户分页查询参数")
public class SysUserPageDTO extends PageParam {

    @Schema(description = "用户名", example = "admin")
    private String username;

    @Schema(description = "用户昵称", example = "Administrator")
    private String nickname;

    @Schema(description = "用户邮箱", example = "admin@example.com")
    private String email;

    @Schema(description = "手机号码", example = "13800138000")
    private String mobile;


}
