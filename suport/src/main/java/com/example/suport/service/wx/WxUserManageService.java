package com.example.suport.service.wx;/*
 * @author p78o2
 * @date 2019/9/26
 */

import com.alibaba.fastjson.JSONObject;
import com.example.api.entity.po.WxUserInfo;
import com.example.api.entity.po.WxUserTag;
import com.example.api.entity.vo.GetUserInfoListVo;
import com.example.api.entity.vo.UserGetVo;
import com.example.api.entity.vo.UserTagVo;

import java.util.List;

//用户管理
public interface WxUserManageService {
//    获取用户openId列表
    public List<String> getUserOpenIds(String wxAppId,String next_openid);
//    获取用户基本信息(单个获取)
    public WxUserInfo getUserInfo(String wxAppId,String openId,String lang);
//    获取用户基本信息(批量获取)
    public List<WxUserInfo> getUserInfoBatchget(String wxAppId,List<String>list);

//    获取公众号创建的标签
    public List<WxUserTag> getUserTag(String wxAppId);
//    创建公众号标签
    public WxUserTag createUserTag(String wxAppId,String name);
//    修改公众号标签
    public boolean editUserTag(String wxAppId,WxUserTag wxUserTag);
//    删除公众号标签
    public boolean deleteUserTag(String wxAppId,int id);
//    获取标签下粉丝openid列表
    public String getTagUsers(String wxAppId,int tagId,String next_openid);
//    为用户批量打上标签
    public boolean setTagsBatchtagging(String wxAppId, UserTagVo userTagVo);
//    为用户批量取消标签
    public boolean deleteTagsBatchtagging(String wxAppId,UserTagVo userTagVo);
//    获取用户标签列表
    public String getUserTagList(String wxAppId,String openId);

//    设置用户备注姓名
    public String setUserRemark(String wxAppId,String openId,String remark);

//    获取公众号黑名单列表
    public String getBlackList(String wxAppId,String begin_openid);
//    拉黑用户
    public String setBlackList(String wxAppId,List<String> openIds);
//    取消拉黑用户
    public String deleteBlackList(String wxAppId,List<String> openIds);
}
