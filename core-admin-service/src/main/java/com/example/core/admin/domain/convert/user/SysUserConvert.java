package com.example.core.admin.domain.convert.user;

import com.example.core.admin.common.converter.GenericConvert;
import com.example.core.admin.domain.dto.user.SysUserDTO;
import com.example.core.admin.domain.po.user.SysUser;
import com.example.core.admin.domain.vo.user.SysUserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


/**
 * @author hy
 * @title: SysUserConvert
 * @projectName core-admin
 * @description: 用户对象转换类
 * @date 2024-10-17 16:50:07 16:50
 */
@Mapper
public interface SysUserConvert extends GenericConvert<SysUserDTO, SysUser, SysUserVO> {

    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);


}

