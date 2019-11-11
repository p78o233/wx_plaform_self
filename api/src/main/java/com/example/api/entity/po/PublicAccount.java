package com.example.api.entity.po;/*
 * @author p78o2
 * @date 2019/9/23
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "公众号账号信息表")
public class PublicAccount {
    @ApiModelProperty(value = "公众号账号",required = false)
    private Integer id;
    @ApiModelProperty(value = "公众号账号名称",required = true)
    private String accountName;
    @ApiModelProperty(value = "公众号appid",required = true)
    private String wxAppId;
    @ApiModelProperty(value = "公众号secertKey",required = true)
    private String wxSecretKey;
    @ApiModelProperty(value = "删除标志位0正常",hidden = true)
    private String isdel;
    @ApiModelProperty(value = "创建时间",hidden = true)
    private Date createTime;
    @ApiModelProperty(value = "创建人",hidden = true)
    private String createUser;
    @ApiModelProperty(value = "修改时间",hidden = true)
    private Date modifyTime;
    @ApiModelProperty(value = "修改人",hidden = true)
    private String modifyUser;

    public PublicAccount() {
    }

    public Integer getId() {

        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getWxAppId() {
        return wxAppId;
    }

    public void setWxAppId(String wxAppId) {
        this.wxAppId = wxAppId;
    }

    public String getWxSecretKey() {
        return wxSecretKey;
    }

    public void setWxSecretKey(String wxSecretKey) {
        this.wxSecretKey = wxSecretKey;
    }

    public String getIsdel() {
        return isdel;
    }

    public void setIsdel(String isdel) {
        this.isdel = isdel;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateUser() {
        return createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifyUser() {
        return modifyUser;
    }

    public void setModifyUser(String modifyUser) {
        this.modifyUser = modifyUser;
    }

    public PublicAccount(Integer id, String accountName, String wxAppId, String wxSecretKey, String isdel, Date createTime, String createUser, Date modifyTime, String modifyUser) {

        this.id = id;
        this.accountName = accountName;
        this.wxAppId = wxAppId;
        this.wxSecretKey = wxSecretKey;
        this.isdel = isdel;
        this.createTime = createTime;
        this.createUser = createUser;
        this.modifyTime = modifyTime;
        this.modifyUser = modifyUser;
    }
}
