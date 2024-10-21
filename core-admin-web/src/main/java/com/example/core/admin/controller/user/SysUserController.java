package com.example.core.admin.controller.user;


import com.example.core.admin.common.po.PageResult;
import com.example.core.admin.common.po.Result;
import com.example.core.admin.domain.dto.user.SysUserDTO;
import com.example.core.admin.domain.dto.user.SysUserPageDTO;
import com.example.core.admin.domain.vo.user.SysUserVO;
import com.example.core.admin.service.user.ISysUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author hy
 * @title: SysUserController
 * @projectName core-admin
 * @description: 用户管理控制器
 * @date 2024-10-17 16:45:13 16:45
 */
@RestController
@RequestMapping("/sys/user")
@RequiredArgsConstructor
@Tag(name = "用户管理相关接口")
public class SysUserController {
    private final ISysUserService service;

    /**
     * 获取用户列表
     *
     * @return 用户列表
     */
    @Operation(summary = "获取用户列表")
    @PostMapping("/page")
    public Result<PageResult<SysUserVO>> page(@RequestBody SysUserPageDTO pageDTO) {
        return Result.success(service.page(pageDTO));
    }

    /**
     * 根据ID获取用户详情
     *
     * @param id 用户ID
     * @return 用户详情
     */
    @Operation(summary = "获取用户详情")
    @GetMapping("/get")
    public Result<SysUserVO> get(@RequestParam @NotNull(message = "id不能为空") String id) {
        return Result.success(service.get(id));
    }

    /**
     * 新增用户
     *
     * @param userDTO 用户传输对象
     * @return 是否新增成功
     */
    @Operation(summary = "新增用户")
    @PostMapping
    public Result<Boolean> save(@Valid @RequestBody SysUserDTO userDTO) {
        return Result.success(service.save(userDTO));
    }

    /**
     * 更新用户
     *
     * @param userDTO 用户传输对象
     * @return 是否更新成功
     */
    @Operation(summary = "更新用户")
    @PutMapping
    public Result<Boolean> update(@Valid @RequestBody SysUserDTO userDTO) {
        return Result.success(service.update(userDTO));
    }

    /**
     * 删除用户
     *
     * @param ids 用户ID
     * @return 是否删除成功
     */
    @Operation(summary = "删除用户")
    @DeleteMapping("/delete")
    public Result<Boolean> delete(@RequestBody @NotEmpty(message = "ids不能为空") List<String> ids) {
        return Result.success(service.remove(ids));
    }
}

