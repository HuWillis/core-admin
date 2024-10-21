package com.example.core.admin.common.exception;

import lombok.Data;

/**
 * @author hy
 * @title: ErrorCode
 * @projectName core-admin
 * @description: 错误码对象
 * @date 2024-10-21 10:29:53 10:29
 */
@Data
public class ErrorCode {

    /**
     * 错误码
     */
    private final Integer code;
    /**
     * 错误提示
     */
    private final String msg;

    public ErrorCode(Integer code, String message) {
        this.code = code;
        this.msg = message;
    }

}
