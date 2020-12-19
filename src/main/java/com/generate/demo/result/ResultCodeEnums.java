package com.generate.demo.result;

/**
 * 异常信息枚举类
 */
public enum ResultCodeEnums {

    REQUEST_SUCCESS("100000", "请求处理成功");

    private String code;

    private String message;

    private ResultCodeEnums(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    //可自定义异常信息描述
    public void setMessage(String message) {
        this.message = message;
    }


}
