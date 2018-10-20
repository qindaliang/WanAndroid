package com.qin.wanandroid.model.http.response;

/**
 * Create by qindl
 * on 2018/10/20
 */
public class BaseBlogResponse<T> {
    private String msg;

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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    private int code;
    private T data;
}
