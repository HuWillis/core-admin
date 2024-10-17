package com.example.core.admin.mapper.user;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.core.admin.domain.po.user.SysUser;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author hy
 * @title: SysUserMapper
 * @projectName core-admin
 * @description: 用户信息表 Mapper 接口
 * @date 2024-10-17 16:46:32 16:46
 */
@Mapper
@ApiModel(description = "用户信息表数据库操作接口")
public interface SysUserMapper extends BaseMapper<SysUser> {

    /**
     * 自定义方法的示例，查询指定用户ID的用户信息
     *
     * @param userId 用户ID
     * @return 用户信息
     */
    @ApiModelProperty(value = "根据用户ID查询用户信息", example = "1")
    SysUser selectUserById(String userId);
}

