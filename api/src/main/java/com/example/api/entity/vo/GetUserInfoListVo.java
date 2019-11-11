package com.example.api.entity.vo;/*
 * @author p78o2
 * @date 2019/9/26
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "获取用户详细信息")
public class GetUserInfoListVo {
    @ApiModelProperty(value = "openid")
    private String openid;
    @ApiModelProperty(value = "语言")
    private String lang;

    public GetUserInfoListVo() {
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public GetUserInfoListVo(String openid, String lang) {
        this.openid = openid;
        this.lang = lang;
    }
}
