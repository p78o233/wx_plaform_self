package com.example.suport.callback;/*
 * @author p78o2
 * @date 2019/9/11
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "返回类")
public class R<T> {
    @ApiModelProperty(value = "是否成功")
    private boolean ret;
    @ApiModelProperty(value = "状态码")
    private int state;
    @ApiModelProperty(value = "返回值")
    private T data;
    @ApiModelProperty(value = "返回消息")
    private String message;

    public R() {
    }

    public boolean isRet() {
        return ret;
    }

    public void setRet(boolean ret) {
        this.ret = ret;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public R(boolean ret, int state, T data, String message) {

        this.ret = ret;
        this.state = state;
        this.data = data;
        this.message = message;
    }
}
