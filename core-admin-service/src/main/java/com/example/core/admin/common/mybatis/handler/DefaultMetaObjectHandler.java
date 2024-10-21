package com.example.core.admin.common.mybatis.handler;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.example.core.admin.common.mybatis.context.TenantContext;
import com.example.core.admin.common.mybatis.po.BasePO;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
 * @author hy
 * @title: DefaultMetaObjectHandler
 * @projectName core-admin
 * @description: TODO
 * @date 2024-10-21 15:06:11 15:06
 */
@Component
@Slf4j
public class DefaultMetaObjectHandler implements MetaObjectHandler {

    /**
     * 新增数据时自动填充
     *
     * @param metaObject 填充对象
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("######新增数据时自动填充");
        if (Objects.nonNull(metaObject) && metaObject.getOriginalObject() instanceof BasePO) {
            BasePO baseDO = (BasePO) metaObject.getOriginalObject();

            DateTime current = DateUtil.date();
            // 创建时间为空，则以当前时间为插入时间
            if (Objects.isNull(baseDO.getCreateTime())) {
                baseDO.setCreateTime(current);
            }
            // 更新时间为空，则以当前时间为更新时间
            if (Objects.isNull(baseDO.getUpdateTime())) {
                baseDO.setUpdateTime(current);
            }

            baseDO.setTenantId(TenantContext.getTenantId());
        }

    }

    /**
     * 更新数据时自动填充
     *
     * @param metaObject 填充对象
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("######更新数据时自动填充");
        // 更新时间为空，则以当前时间为更新时间
        Object modifyTime = getFieldValByName("updateTime", metaObject);
        if (Objects.isNull(modifyTime)) {
            setFieldValByName("updateTime", DateUtil.date(), metaObject);
        }

    }
}
