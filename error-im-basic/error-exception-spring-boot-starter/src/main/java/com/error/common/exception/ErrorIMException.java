package com.error.common.exception;

import com.error.model.common.constants.BaseCode;

public class ErrorIMException extends RuntimeException {

    // 异常处理的枚举
    private BaseCode baseCode;

    public ErrorIMException(BaseCode baseCode) {
        super(baseCode.getErrorMessage());
        this.baseCode = baseCode;
    }
    public ErrorIMException(BaseCode baseCode, String msg) {
        super(msg);
        baseCode.setErrorMessage(msg);
        this.baseCode = baseCode;
    }
    public BaseCode getBaseCode() {
        return baseCode;
    }
}