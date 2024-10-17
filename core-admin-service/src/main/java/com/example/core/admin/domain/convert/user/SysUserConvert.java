package com.example.core.admin.domain.convert.user;

import com.example.core.admin.domain.dto.user.SysUserDTO;
import com.example.core.admin.domain.po.user.SysUser;
import com.example.core.admin.domain.vo.user.SysUserVO;
import java.util.List;
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
public interface SysUserConvert {

    SysUserConvert INSTANCE = Mappers.getMapper(SysUserConvert.class);

    /**
     * DTO 转 PO
     *
     * @param sysUserDTO 用户数据传输对象
     * @return 用户持久化对象
     */
    // ID通常是由数据库生成，不从DTO传递
    SysUser dtoToPo(SysUserDTO sysUserDTO);

    /**
     * PO 转 VO
     *
     * @param sysUser 用户持久化对象
     * @return 用户视图对象
     */
    SysUserVO poToVo(SysUser sysUser);

    /**
     * DTO 转 VO
     *
     * @param sysUserDTO 用户数据传输对象
     * @return 用户视图对象
     */
    SysUserVO dtoToVo(SysUserDTO sysUserDTO);

    /**
     * VO 转 PO
     *
     * @param sysUserVO 用户视图对象
     * @return 用户持久化对象
     */
    SysUser voToPo(SysUserVO sysUserVO);

    /**
     * 批量 DTO 转 PO
     *
     * @param sysUserDTOList 用户DTO列表
     * @return 用户PO列表
     */
    List<SysUser> dtoListToPoList(List<SysUserDTO> sysUserDTOList);

    /**
     * 批量 PO 转 VO
     *
     * @param sysUserList 用户PO列表
     * @return 用户VO列表
     */
    List<SysUserVO> poListToVoList(List<SysUser> sysUserList);
}

