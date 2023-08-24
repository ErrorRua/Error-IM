package com.error.model.common.dtos;


import lombok.Getter;
import lombok.Setter;
import com.error.model.common.constants.BaseCode;
import com.error.model.common.enums.AppHttpCodeEnum;

import java.io.Serializable;

/**
 * 通用的结果返回类
 * @param <T>
 */
@Setter
@Getter
public class ResponseResult<T> implements Serializable {
    private String host; // IP
    private Integer code = 200;  // 状态码
    private String errorMessage;  // 提示信息
    private T data;  // 数据 Object

    public ResponseResult() {
    }
    public ResponseResult(Integer code, T data) {
        this.code = code;
        this.data = data;
    }
    public ResponseResult(Integer code, String msg, T data) {
        this.code = code;
        this.errorMessage = msg;
        this.data = data;
    }
    public ResponseResult(Integer code, String msg) {
        this.code = code;
        this.errorMessage = msg;
    }
    public static ResponseResult errorResult(int code, String msg) {
        ResponseResult result = new ResponseResult();
        return result.error(code, msg);
    }

    public static ResponseResult okResult(int code, String msg) {
        ResponseResult result = new ResponseResult();
        return result.ok(code, null, msg);
    }
    public static ResponseResult okResult(Object data) {
        ResponseResult result = setBaseCode(AppHttpCodeEnum.SUCCESS, AppHttpCodeEnum.SUCCESS.getErrorMessage());
        if(data!=null) {
            result.setData(data);
        }
        return result;
    }
    public static ResponseResult okResult() {
        return okResult(null);
    }
    public static ResponseResult errorResult(BaseCode enums){
        return setBaseCode(enums,enums.getErrorMessage());
    }
    public static ResponseResult errorResult(BaseCode enums, String errorMessage){
        return setBaseCode(enums,errorMessage);
    }
    public static ResponseResult setBaseCode(BaseCode enums){
        return okResult(enums.getCode(),enums.getErrorMessage());
    }
    private static ResponseResult setBaseCode(BaseCode enums, String errorMessage){
        return okResult(enums.getCode(),errorMessage);
    }
    public ResponseResult<?> error(Integer code, String msg) {
        this.code = code;
        this.errorMessage = msg;
        return this;
    }
    public ResponseResult<?> ok(Integer code, T data) {
        this.code = code;
        this.data = data;
        return this;
    }
    public ResponseResult<?> ok(Integer code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.errorMessage = msg;
        return this;
    }
    public ResponseResult<?> ok(T data) {
        this.data = data;
        return this;
    }

    public boolean checkCode() {
        if(this.getCode().intValue() != 0){
            return false;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
