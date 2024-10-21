package com.example.core.admin.common.converter;

import java.util.List;


/**
 * @author hy
 * @title: GenericConvert
 * @projectName core-admin
 * @description: TODO
 * @date 2024-10-21 09:38:29 09:38
 */
public interface GenericConvert<D, P, V> {

    /**
     * DTO 转 PO
     *
     * @param dto 数据传输对象
     * @return 持久化对象
     */
    P dtoToPo(D dto);

    /**
     * PO 转 VO
     *
     * @param po 持久化对象
     * @return 视图对象
     */
    V poToVo(P po);

    /**
     * DTO 转 VO
     *
     * @param dto 数据传输对象
     * @return 视图对象
     */
    V dtoToVo(D dto);

    /**
     * VO 转 PO
     *
     * @param vo 视图对象
     * @return 持久化对象
     */
    P voToPo(V vo);

    /**
     * 批量 DTO 转 PO
     *
     * @param dtoList 数据传输对象列表
     * @return 持久化对象列表
     */
    List<P> dtoListToPoList(List<D> dtoList);

    /**
     * 批量 PO 转 VO
     *
     * @param poList 持久化对象列表
     * @return 视图对象列表
     */
    List<V> poListToVoList(List<P> poList);
}

