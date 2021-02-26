package com.china315net.serviceauth.dto;

import org.springframework.core.annotation.Order;

import java.io.Serializable;


public class ResponseDTO<T> implements Serializable {

    @Order(1)
    private String code;
    @Order(2)
    private String msg;
    @Order(3)
    private Long ctime;
    @Order(4)
    private T data;

    public ResponseDTO(String code, String msg) {
        this.code = code;
        this.msg = msg;
        this.ctime = System.currentTimeMillis();
    }

    /**
     *
     * @return
     */
    public static ResponseDTO ok() {
        return new ResponseDTO("E0000", "ok");
    }
    //构建系统异常返回
    public static ResponseDTO error() {
        return new ResponseDTO("E5000", "false");
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public ResponseDTO<T> setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public Long getCtime() {
        return ctime;
    }

    public void setCtime(Long ctime) {
        this.ctime = ctime;
    }

    public T getData() {
        return data;
    }

    public ResponseDTO<T> setData(T data) {
        this.data = data;
        return this;
    }

}