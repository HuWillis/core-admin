package com.example.core.admin.service.user.impl;

import com.example.core.admin.domain.dto.user.SysUserDTO;
import com.example.core.admin.domain.vo.user.SysUserVO;
import com.example.core.admin.mapper.user.SysUserMapper;
import com.example.core.admin.service.user.ISysUserService;
import java.util.Collections;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author hy
 * @title: SysUserServiceImpl
 * @projectName core-admin
 * @description: TODO
 * @date 2024-10-17 17:06:06 17:06
 */
@Service
@RequiredArgsConstructor
public class SysUserServiceImpl implements ISysUserService {
    private final SysUserMapper sysUserMapper;

    /**
     * 获取用户列表
     *
     * @return 用户列表
     */
    @Override
    public List<SysUserVO> listUsers() {
        return Collections.emptyList();
    }

    /**
     * 根据ID获取用户详情
     *
     * @param userId@return 用户详情
     */
    @Override
    public SysUserVO getUserById(String userId) {
        return null;
    }

    /**
     * 新增用户
     *
     * @param userDTO 用户数据传输对象
     * @return 是否成功
     */
    @Override
    public boolean addUser(SysUserDTO userDTO) {
        return false;
    }

    /**
     * 更新用户
     *
     * @param userDTO 用户数据传输对象
     * @return 是否成功
     */
    @Override
    public boolean updateUser(SysUserDTO userDTO) {
        return false;
    }

    /**
     * 删除用户
     *
     * @param userId@return 是否成功
     */
    @Override
    public boolean deleteUser(String userId) {
        return false;
    }
}
