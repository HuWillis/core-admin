package com.example.core.admin.service.user.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.core.admin.common.po.PageResult;
import com.example.core.admin.domain.convert.user.SysUserConvert;
import com.example.core.admin.domain.dto.user.SysUserDTO;
import com.example.core.admin.domain.dto.user.SysUserPageDTO;
import com.example.core.admin.domain.po.user.SysUser;
import com.example.core.admin.domain.vo.user.SysUserVO;
import com.example.core.admin.mapper.user.SysUserMapper;
import com.example.core.admin.service.user.ISysUserService;
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

    private final SysUserMapper mapper;


    /**
     * 分页查询用户列表
     *
     * @param pageDTO 分页参数
     * @return 用户列表
     */
    @Override
    public PageResult<SysUserVO> page(SysUserPageDTO pageDTO) {
        IPage<SysUser> page = mapper.page(pageDTO);
        return new PageResult<SysUserVO>(
            SysUserConvert.INSTANCE.poListToVoList(page.getRecords()),
            page.getTotal()
        );
    }

    /**
     * 根据用户ID查询用户信息
     *
     * @param id 用户ID
     * @return 用户信息
     */
    @Override
    public SysUserVO get(String id) {
        SysUser po = mapper.selectById(id);
        return SysUserConvert.INSTANCE.poToVo(po);
    }

    /**
     * 新增用户
     *
     * @param userDTO 用户信息
     * @return 是否成功
     */
    @Override
    public Boolean save(SysUserDTO userDTO) {
        SysUser po = SysUserConvert.INSTANCE.dtoToPo(userDTO);
        return mapper.insert(po) > 0;
    }

    /**
     * 更新用户信息
     *
     * @param userDTO 用户信息
     * @return 是否成功
     */
    @Override
    public Boolean update(SysUserDTO userDTO) {
        SysUser po = SysUserConvert.INSTANCE.dtoToPo(userDTO);
        return mapper.updateById(po) > 0;
    }

    /**
     * 删除用户信息
     *
     * @param ids 用户ID列表
     * @return 是否成功
     */
    @Override
    public Boolean remove(List<String> ids) {
        return mapper.deleteBatchIds(ids) > 0;
    }
}
