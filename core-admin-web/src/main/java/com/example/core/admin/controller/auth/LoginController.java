package com.example.core.admin.controller.auth;

import com.example.core.admin.common.po.Result;
import com.example.core.admin.domain.dto.user.SysUserDTO;
import com.example.core.admin.domain.vo.user.SysUserVO;
import com.example.core.admin.service.user.ISysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huyong
 * @version 1.0 {@code @project} core-admin {@code @date} 2024/10/4 18:11 {@code @description:} TODO
 */
@RestController
@RequestMapping("/auth/login")
@RequiredArgsConstructor
@Tag(name = "登录注册相关接口")
public class LoginController {

    private final ISysUserService service;

    /**
     * 登录接口
     *
     * @param userDTO 用户传输对象
     * @return 用户详情
     */
    @Operation(summary = "获取用户详情")
    @GetMapping("/login")
    public Result<SysUserVO> login(@RequestBody SysUserDTO userDTO) {
        return Result.success(service.login(userDTO));
    }
}
