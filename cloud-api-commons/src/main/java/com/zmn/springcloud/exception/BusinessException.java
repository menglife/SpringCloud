package com.zmn.springcloud.exception;

import com.zmn.springcloud.CodeEnum;
import lombok.Data;

import java.text.MessageFormat;

@Data
public class BusinessException extends RuntimeException{
    private Integer code;
    public BusinessException(String message) {
        super(message);
        this.code= CodeEnum.OPERATION_FAIL.getCode();

    }

    public BusinessException(String message, Integer code) {
        super(message);
        this.code = code;
    }
    public BusinessException(String message, Object ...args) {
        super(MessageFormat.format(message, args));
        this.code = CodeEnum.OPERATION_FAIL.getCode();

    }

}

