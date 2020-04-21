package com.gyh;

public enum ErrorCode {
    SUCCESS(200,"成功"),ERROR1(404,"页面找不到"),ERROR2(500,"系统路径错误");

    private int code;
    private String errmsg;

    ErrorCode(int code, String errmsg) {
        this.code = code;
        this.errmsg = errmsg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
}
