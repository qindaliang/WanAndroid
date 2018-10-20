package com.qin.wanandroid.model.http.exception;

/**
 * Create by qindl
 * on 2018/10/20
 */
public class ServerException extends RuntimeException {
    private String msg;
    private int code;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public ServerException(String msg) {
        this.msg = msg;
    }
}
