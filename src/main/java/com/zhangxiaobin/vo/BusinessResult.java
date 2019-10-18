package com.zhangxiaobin.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusinessResult<T> implements Serializable {

    private Long code;

    private String message;

    private T data;

    public static <T> BusinessResult createSuccessInstance(T data) {
        return new BusinessResult<T>(CommonResultMessage.SUCCESS.code, CommonResultMessage.SUCCESS.message, data);
    }

    public static <T> BusinessResult createInstance(CommonResultMessage message) {
        return new BusinessResult<T>(message.getCode(), message.getMessage(), null);
    }

    public static <T> BusinessResult createInstance(CommonResultMessage message,T data) {
        return new BusinessResult<T>(message.getCode(), message.getMessage(), data);
    }

    public static <T> BusinessResult createInstance(Long code,String message,T data) {
        return new BusinessResult<T>(code, message, data);
    }
}
