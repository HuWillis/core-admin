package com.example.core.admin.service.user;


import com.example.core.admin.domain.dto.user.SysUserDTO;
import com.example.core.admin.domain.vo.user.SysUserVO;
import java.util.List;


/**
 * @author hy
 * @title: SysUserService
 * @projectName core-admin
 * @description: 用户信息服务接口
 * @date 2024-10-17 16:43:04 16:43
 */
public interface ISysUserService {

    /**
     * 获取用户列表
     *
     * @return 用户列表
     */
    List<SysUserVO> listUsers();

    /**
     * 根据ID获取用户详情
     *
     * @param id 用户ID
     * @return 用户详情
     */
    SysUserVO getUserById(String userId);

    /**
     * 新增用户
     *
     * @param userDTO 用户数据传输对象
     * @return 是否成功
     */
    boolean addUser(SysUserDTO userDTO);

    /**
     * 更新用户
     *
     * @param userDTO 用户数据传输对象
     * @return 是否成功
     */
    boolean updateUser(SysUserDTO userDTO);

    /**
     * 删除用户
     *
     * @param id 用户ID
     * @return 是否成功
     */
    boolean deleteUser(String userId);
}
