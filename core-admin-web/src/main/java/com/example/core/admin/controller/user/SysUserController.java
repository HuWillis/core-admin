package com.example.core.admin.controller.user;


import com.example.core.admin.domain.dto.user.SysUserDTO;
import com.example.core.admin.domain.vo.user.SysUserVO;
import com.example.core.admin.service.user.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
@Api(tags = "用户管理", value = "SysUserController", description = "用户管理相关接口")
public class SysUserController {

    private final ISysUserService sysUserService;

    /**
     * 获取用户列表
     *
     * @return 用户列表
     */
    @ApiOperation(value = "获取用户列表", notes = "查询所有用户的列表")
    @GetMapping
    public List<SysUserVO> listUsers() {
        return sysUserService.listUsers();
    }

    /**
     * 根据ID获取用户详情
     *
     * @param userId 用户ID
     * @return 用户详情
     */
    @ApiOperation(value = "获取用户详情", notes = "通过用户ID获取用户详情")
    @GetMapping("/get")
    public SysUserVO get(
        @ApiParam(value = "用户ID", required = true, example = "1") @PathVariable String userId) {
        return sysUserService.getUserById(userId);
    }

    /**
     * 新增用户
     *
     * @param userDTO 用户传输对象
     * @return 是否新增成功
     */
    @ApiOperation(value = "新增用户", notes = "添加新的用户")
    @PostMapping
    public boolean addUser(
        @ApiParam(value = "用户数据传输对象", required = true) @Valid @RequestBody SysUserDTO userDTO) {
        return sysUserService.addUser(userDTO);
    }

    /**
     * 更新用户
     *
     * @param userDTO 用户传输对象
     * @return 是否更新成功
     */
    @ApiOperation(value = "更新用户", notes = "根据用户ID更新用户信息")
    @PutMapping
    public boolean updateUser(
        @ApiParam(value = "用户数据传输对象", required = true) @Valid @RequestBody SysUserDTO userDTO) {
        return sysUserService.updateUser(userDTO);
    }

    /**
     * 删除用户
     *
     * @param userId 用户ID
     * @return 是否删除成功
     */
    @ApiOperation(value = "删除用户", notes = "根据用户ID删除用户")
    @DeleteMapping("/{id}")
    public boolean deleteUser(
        @ApiParam(value = "用户ID", required = true, example = "1") @PathVariable String userId) {
        return sysUserService.deleteUser(userId);
    }


}

