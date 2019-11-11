package com.example.api.entity.po;/*
 * @author p78o2
 * @date 2019/9/27
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "用户标签")
public class WxUserTag {
    @ApiModelProperty(value = "主键id")
    private Integer id;
    @ApiModelProperty(value = "标签id")
    private int tagId;
    @ApiModelProperty(value = "标签名字")
    private String name;
    @ApiModelProperty(value = "标签下的粉丝数")
    private int count;
    @ApiModelProperty(value = "微信appId")
    private String wxAppId;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "是否删除0正常 1删除")
    private boolean isdel;

    public WxUserTag() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getTagId() {
        return tagId;
    }

    public void setTagId(int tagId) {
        this.tagId = tagId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getWxAppId() {
        return wxAppId;
    }

    public void setWxAppId(String wxAppId) {
        this.wxAppId = wxAppId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean isIsdel() {
        return isdel;
    }

    public void setIsdel(boolean isdel) {
        this.isdel = isdel;
    }

    public WxUserTag(Integer id, int tagId, String name, int count, String wxAppId, Date createTime, boolean isdel) {
        this.id = id;
        this.tagId = tagId;
        this.name = name;
        this.count = count;
        this.wxAppId = wxAppId;
        this.createTime = createTime;
        this.isdel = isdel;
    }
}
