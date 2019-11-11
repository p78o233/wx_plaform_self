package com.example.api.entity.vo;/*
 * @author p78o2
 * @date 2019/9/25
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "获取accessToken返回值")
public class AccessTokenVo {
    @ApiModelProperty(value = "accessToken")
    private String accessToken;
    @ApiModelProperty(value = "还有多长时间token失效")
    private long expiresIn;

    public AccessTokenVo() {
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public AccessTokenVo(String accessToken, long expiresIn) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
    }
}
