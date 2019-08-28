package com.community.exception;

/**
 * @author Com.OceanLee
 * @date 2019/8/28 22:32
 */
public class CustomizeException extends RuntimeException {

    private String message;

    public CustomizeException (String message){
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

}
