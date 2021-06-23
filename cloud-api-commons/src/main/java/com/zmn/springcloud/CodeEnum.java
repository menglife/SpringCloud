package com.zmn.springcloud;

public enum CodeEnum {
    //成功状态
    OK(200,"OK"),
    //参数错误
    PARAM_ERROR(400,"param error"),
    //权限错误
    UNAUTHORIZED(401, "Unauthorized"),
    //内部服务器错误
    FAIL(500, "sever error"),
    //sessiony异常
    SESSION_INVALIDE(-1, "operation fail"),
    /**
     * 统一用户操作失败状态，减少前端工作量
     */
    OPERATION_FAIL(1000, "operation fail"),
    /**
     * 验证码失效
     */
    CODE_INVALID(1001, "validate code is Invalid"),
    /**
     * 外层异常梳理返回code
     */
    OPERATION_EXCEPTION(1002, "operation exception"),
    ;

    private int code;
    private String value;

    CodeEnum(int code, String value) {
        this.code = code;
        this.value = value;
    }

    public int getCode() {
        return code;
    }

    public String getValue() {
        return value;
    }
}
