package com.common.api.response;

public class ResponseResult<T> {

    private Integer code;
    private String message;
    private T data;
    private String port;

    public ResponseResult() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public ResponseResult(Integer code , String message, T data, String port){
        this.code=code;
        this.message=message;
        this.data=data;
        this.port=port;
    }

    @Override
    public String toString() {
        return "ResponseResult{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                ", port='" + port + '\'' +
                '}';
    }
}
