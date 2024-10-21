package com.example.core.admin.service.user;


import com.example.core.admin.common.po.PageResult;
import com.example.core.admin.domain.dto.user.SysUserDTO;
import com.example.core.admin.domain.dto.user.SysUserPageDTO;
import com.example.core.admin.domain.vo.user.SysUserVO;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


/**
 * @author hy
 * @title: SysUserService
 * @projectName core-admin
 * @description: 用户信息服务接口
 * @date 2024-10-17 16:43:04 16:43
 */
public interface ISysUserService {

    /**
     * 分页查询用户列表
     *
     * @param pageDTO 分页参数
     * @return 用户列表
     */
    PageResult<SysUserVO> page(SysUserPageDTO pageDTO);

    /**
     * 根据用户ID查询用户信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
    SysUserVO get(@NotNull(message = "id不能为空") String id);

    /**
     * 新增用户
     *
     * @param userDTO 用户信息
     * @return 是否成功
     */
    Boolean save(@Valid SysUserDTO userDTO);

    /**
     * 更新用户信息
     *
     * @param userDTO 用户信息
     * @return 是否成功
     */
    Boolean update(@Valid SysUserDTO userDTO);

    /**
     * 删除用户信息
     *
     * @param ids 用户ID列表
     * @return 是否成功
     */
    Boolean remove(@NotEmpty(message = "ids不能为空") List<String> ids);

    /**
     * 用户登录
     *
     * @param userDTO 用户信息
     * @return 用户信息
     */
    SysUserVO login(SysUserDTO userDTO);
}
