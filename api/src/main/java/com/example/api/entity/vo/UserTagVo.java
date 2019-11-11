package com.example.api.entity.vo;/*
 * @author p78o2
 * @date 2019/9/29
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

@ApiModel(value = "批量处理用户标签")
public class UserTagVo {
    @ApiModelProperty(value = "openid列表")
    private List<String> openid_list;
    @ApiModelProperty(value = "标签id")
    private int tagid;

    public UserTagVo() {
    }

    public List<String> getOpenid_list() {
        return openid_list;
    }

    public void setOpenid_list(List<String> openid_list) {
        this.openid_list = openid_list;
    }

    public int getTagid() {
        return tagid;
    }

    public void setTagid(int tagid) {
        this.tagid = tagid;
    }

    public UserTagVo(List<String> openid_list, int tagid) {
        this.openid_list = openid_list;
        this.tagid = tagid;
    }
}
