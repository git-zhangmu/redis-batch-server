package com.zhangxiaobin.vo;


public enum CommonResultMessage {

    SUCCESS(0L, "成功")
    ;

    public final Long code;
    public final String message;

    CommonResultMessage(Long code, String message) {
        this.code = code;
        this.message = message;
    }

    public static CommonResultMessage getResult(Long code) {
        for (CommonResultMessage resultMessage : CommonResultMessage.values()) {
            if (resultMessage.code.equals(code)) {
                return resultMessage;
            }
        }
        return null;
    }

    public Long getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }
}
