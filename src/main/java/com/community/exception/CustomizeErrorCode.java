package com.community.exception;

/**
 * @author Com.OceanLee
 * @date 2019/8/29 21:08
 * 定义错误码
 */
public enum  CustomizeErrorCode  implements ICustomizeErrorCode{

    QUESTION_NOT_FOUND("你找得问题不在了，要不要换个试试?");

    //错误信息
    @Override
    public String getMessage() {
        return message;
    }

    private String message;

    CustomizeErrorCode(String message) {
        this.message = message;
    }




}
