package com.example.api.entity.po;/*
 * @author p78o2
 * @date 2019/9/26
 */

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

@ApiModel(value = "用户详细信息")
public class WxUserInfo {
    @ApiModelProperty(value = "id")
    private Integer id;
    @ApiModelProperty(value = "用户是否订阅该公众号标识，值为0时，代表此用户没有关注该公众号，拉取不到其余信息。")
    private boolean subscribe;
    @ApiModelProperty(value = "用户的标识，对当前公众号唯一")
    private String openid;
    @ApiModelProperty(value = "用户的昵称")
    private String nickname;
    @ApiModelProperty(value = "用户的性别，值为1时是男性，值为2时是女性，值为0时是未知")
    private int sex;
    @ApiModelProperty(value = "用户所在城市")
    private String city;
    @ApiModelProperty(value = "用户所在国家")
    private String country;
    @ApiModelProperty(value = "用户所在省份")
    private String province;
    @ApiModelProperty(value = "用户的语言，简体中文为zh_CN")
    private String language;
    @ApiModelProperty(value = "用户头像")
    private String headimgurl;
    @ApiModelProperty(value = "用户关注时间，为时间戳。如果用户曾多次关注，则取最后关注时间")
    private Date subscribe_time;
    @ApiModelProperty(value = "只有在用户将公众号绑定到微信开放平台帐号后，才会出现该字段。")
    private String unionid;
    @ApiModelProperty(value = "公众号运营者对粉丝的备注，公众号运营者可在微信公众平台用户管理界面对粉丝添加备注")
    private String remark;
    @ApiModelProperty(value = "用户所在的分组ID（兼容旧的用户分组接口）")
    private String groupid;
    @ApiModelProperty(value = "用户被打上的标签ID列表")
    private String tagid_list;
    @ApiModelProperty(value = "返回用户关注的渠道来源，ADD_SCENE_SEARCH 公众号搜索，" +
            "ADD_SCENE_ACCOUNT_MIGRATION 公众号迁移，ADD_SCENE_PROFILE_CARD 名片分享，" +
            "ADD_SCENE_QR_CODE 扫描二维码，ADD_SCENE_PROFILE_ LINK 图文页内名称点击，" +
            "ADD_SCENE_PROFILE_ITEM 图文页右上角菜单，ADD_SCENE_PAID 支付后关注，ADD_SCENE_OTHERS 其他")
    private String subscribe_scene;
    @ApiModelProperty(value = "二维码扫码场景（开发者自定义）")
    private String qr_scene;
    @ApiModelProperty(value = "二维码扫码场景描述（开发者自定义）")
    private String qr_scene_str;
    @ApiModelProperty(value = "公众号appId")
    private String wxAppId;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "用户是否在黑名单内0不是 1是")
    private boolean isBlackList;

    public WxUserInfo() {
    }

    public boolean isSubscribe() {
        return subscribe;
    }

    public void setSubscribe(boolean subscribe) {
        this.subscribe = subscribe;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getHeadimgurl() {
        return headimgurl;
    }

    public void setHeadimgurl(String headimgurl) {
        this.headimgurl = headimgurl;
    }

    public Date getSubscribe_time() {
        return subscribe_time;
    }

    public void setSubscribe_time(Date subscribe_time) {
        this.subscribe_time = subscribe_time;
    }

    public String getUnionid() {
        return unionid;
    }

    public void setUnionid(String unionid) {
        this.unionid = unionid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getGroupid() {
        return groupid;
    }

    public void setGroupid(String groupid) {
        this.groupid = groupid;
    }

    public String getTagid_list() {
        return tagid_list;
    }

    public void setTagid_list(String tagid_list) {
        this.tagid_list = tagid_list;
    }

    public String getSubscribe_scene() {
        return subscribe_scene;
    }

    public void setSubscribe_scene(String subscribe_scene) {
        this.subscribe_scene = subscribe_scene;
    }

    public String getQr_scene() {
        return qr_scene;
    }

    public void setQr_scene(String qr_scene) {
        this.qr_scene = qr_scene;
    }

    public String getQr_scene_str() {
        return qr_scene_str;
    }

    public void setQr_scene_str(String qr_scene_str) {
        this.qr_scene_str = qr_scene_str;
    }

    public String getWxAppId() {
        return wxAppId;
    }

    public void setWxAppId(String wxAppId) {
        this.wxAppId = wxAppId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public boolean isBlackList() {
        return isBlackList;
    }

    public void setBlackList(boolean blackList) {
        isBlackList = blackList;
    }

    public WxUserInfo(Integer id, boolean subscribe, String openid, String nickname, int sex, String city, String country, String province, String language, String headimgurl, Date subscribe_time, String unionid, String remark, String groupid, String tagid_list, String subscribe_scene, String qr_scene, String qr_scene_str, String wxAppId, Date createTime, boolean isBlackList) {
        this.id = id;
        this.subscribe = subscribe;
        this.openid = openid;
        this.nickname = nickname;
        this.sex = sex;
        this.city = city;
        this.country = country;
        this.province = province;
        this.language = language;
        this.headimgurl = headimgurl;
        this.subscribe_time = subscribe_time;
        this.unionid = unionid;
        this.remark = remark;
        this.groupid = groupid;
        this.tagid_list = tagid_list;
        this.subscribe_scene = subscribe_scene;
        this.qr_scene = qr_scene;
        this.qr_scene_str = qr_scene_str;
        this.wxAppId = wxAppId;
        this.createTime = createTime;
        this.isBlackList = isBlackList;
    }
}
