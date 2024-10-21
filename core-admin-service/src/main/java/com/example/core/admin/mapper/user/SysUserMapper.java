package com.example.core.admin.mapper.user;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.core.admin.domain.dto.user.SysUserPageDTO;
import com.example.core.admin.domain.po.user.SysUser;
import io.swagger.v3.oas.annotations.media.Schema;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author hy
 * @title: SysUserMapper
 * @projectName core-admin
 * @description: 用户信息表 Mapper 接口
 * @date 2024-10-17 16:46:32 16:46
 */
@Mapper
@Schema(description = "用户信息表数据库操作接口")
public interface SysUserMapper extends BaseMapper<SysUser> {


    /**
     * 分页查询用户信息
     *
     * @param pageDTO 分页参数
     * @return 分页结果
     */
    default IPage<SysUser> page(SysUserPageDTO pageDTO) {
        Page<SysUser> page = new Page<>(pageDTO.getPageNo(), pageDTO.getPageSize());
        return selectPage(page, new LambdaQueryWrapper<SysUser>()
            .like(StrUtil.isNotBlank(pageDTO.getUsername()), SysUser::getUsername, pageDTO.getUsername())
            .like(StrUtil.isNotBlank(pageDTO.getNickname()), SysUser::getNickname, pageDTO.getNickname())
            .like(StrUtil.isNotBlank(pageDTO.getMobile()), SysUser::getMobile, pageDTO.getMobile())
            .like(StrUtil.isNotBlank(pageDTO.getEmail()), SysUser::getEmail, pageDTO.getEmail())
        );
    }
}

