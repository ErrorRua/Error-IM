package com.error.common.exception;


import com.error.model.common.constants.BaseCode;

/**
 * @Description:  抛异常工具类
 * @Version: V1.0
 */
public class ErrorIMExceptions {
    public static void throwException(BaseCode codeEnum) {
        throw new ErrorIMException(codeEnum);
    }
    public static void throwException(BaseCode codeEnum,String msg) {
        throw new ErrorIMException(codeEnum,msg);
    }
}