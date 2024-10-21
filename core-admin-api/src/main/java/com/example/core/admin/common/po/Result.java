package com.example.core.admin.common.po;

import cn.hutool.core.lang.Assert;
import com.example.core.admin.common.exception.ErrorCode;
import com.example.core.admin.common.exception.GlobalErrorCodeConstants;
import com.example.core.admin.common.exception.ServiceException;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import lombok.Data;

/**
 * @author hy
 * @title: Result
 * @projectName core-admin
 * @description: TODO
 * @date 2024-10-21 10:20:31 10:20
 */
@Data
@Schema(description = "全局统一返回结果")
public class Result<T> implements Serializable {

    /**
     * 错误码
     *
     * @see ErrorCode#getCode()
     */
    @Schema(description = "业务错误码")
    private Integer code;
    /**
     * 返回数据
     */
    @Schema(description = "业务数据")
    private T data;
    /**
     * 错误提示，用户可阅读
     *
     * @see ErrorCode#getMsg() ()
     */
    @Schema(description = "业务提示")
    private String msg;
    /**
     * 响应时间
     */
    @Schema(description = "响应时间")
    @JsonFormat(
        shape = Shape.STRING,
        pattern = "yyyy-MM-dd HH:mm:ss",
        timezone = "UTC+8"
    )
    private LocalDateTime time;

    /**
     * 将传入的 result 对象，转换成另外一个泛型结果的对象
     * <p>
     * 因为 A 方法返回的 Result 对象，不满足调用其的 B 方法的返回，所以需要进行转换。
     *
     * @param result 传入的 result 对象
     * @param <T>    返回的泛型
     * @return 新的 Result 对象
     */
    public static <T> Result<T> error(Result<?> result) {
        return error(result.getCode(), result.getMsg());
    }

    public static <T> Result<T> error(Integer code, String message) {
        Assert.isTrue(!GlobalErrorCodeConstants.SUCCESS.getCode().equals(code),
            "code 必须是错误的！");
        Result<T> result = new Result<>();
        result.code = code;
        result.msg = message;
        result.time = LocalDateTime.now();
        return result;
    }

    public static <T> Result<T> error(ErrorCode errorCode) {
        return error(errorCode.getCode(), errorCode.getMsg());
    }

    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.code = GlobalErrorCodeConstants.SUCCESS.getCode();
        result.data = data;
        result.time = LocalDateTime.now();
        result.msg = "";
        return result;
    }

    public static boolean isSuccess(Integer code) {
        return Objects.equals(code, GlobalErrorCodeConstants.SUCCESS.getCode());
    }

    @JsonIgnore
    public boolean isSuccess() {
        return isSuccess(code);
    }

    @JsonIgnore
    public boolean isError() {
        return !isSuccess();
    }

    /**
     * 判断是否有异常。如果有，则抛出 {@link ServiceException} 异常
     */
    public void checkError() throws ServiceException {
        if (isSuccess()) {
            return;
        }
        // 业务异常
        throw new ServiceException(code, msg);
    }

    /**
     * 判断是否有异常。如果有，则抛出 {@link ServiceException} 异常 如果没有，则返回 {@link #data} 数据
     */
    @JsonIgnore
    public T getCheckedData() {
        checkError();
        return data;
    }

    public static <T> Result<T> error(ServiceException serviceException) {
        return error(serviceException.getCode(), serviceException.getMessage());
    }

}
