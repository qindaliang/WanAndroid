package com.qin.wanandroid.model.http.exception;

/**
 * Create by qindl
 * on 2018/10/20
 */
public class ServerResponseException extends RuntimeException {
    public ServerResponseException(int errorCode, String cause) {
        super("服务器响应失败，错误码："+errorCode+"，错误原因"+cause, new Throwable("Server error"));
    }
}
