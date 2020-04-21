package com.gyh;

public class APIException extends  RuntimeException {
    private ErrorCode errorCode;

    public APIException(ErrorCode errorCode){
       this.errorCode=errorCode;
    }
}
