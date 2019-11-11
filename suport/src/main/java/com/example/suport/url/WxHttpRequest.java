package com.example.suport.url;/*
 * @author p78o2
 * @date 2019/9/25
 */

import com.alibaba.fastjson.JSONObject;
import com.example.suport.utils.HttpUtils;

import java.util.HashMap;
import java.util.Map;

public class WxHttpRequest {
    //获取accessToken
    public static String getAccessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token";
//    获取用户列表
    public static String getUserGetUrl = "https://api.weixin.qq.com/cgi-bin/user/get";
//    获取用户详细信息（单个获取）
    public static String getUserInfoUrl = "https://api.weixin.qq.com/cgi-bin/user/info";
//    获取用户详细信息批量
    public static String getUserInfoBatchgetUrl = "https://api.weixin.qq.com/cgi-bin/user/info/batchget?access_token=";
//    创建标签
    public static String createTagUrl="https://api.weixin.qq.com/cgi-bin/tags/create?access_token=";
//    获取标签
    public static String getTagUrl = "https://api.weixin.qq.com/cgi-bin/tags/get";
//    修改标签
    public static String editTagUrl = "https://api.weixin.qq.com/cgi-bin/tags/update?access_token=";
//    删除标签
    public static String deleteTagUrl = "https://api.weixin.qq.com/cgi-bin/tags/delete?access_token=";
//    获取标签下粉丝列表
    public static String getTagUsersUrl = "https://api.weixin.qq.com/cgi-bin/user/tag/get?access_token=";
//    批量为用户打标签
    public static String setTagsBatchtaggingUrl = "https://api.weixin.qq.com/cgi-bin/tags/members/batchtagging?access_token=";
//    批量为用户取消标签
    public static String deleteTagsBatchtaggingUrl = "https://api.weixin.qq.com/cgi-bin/tags/members/batchuntagging?access_token=";
//    获取用户身上的标签列表
    public static String getUserTagListUrl = "https://api.weixin.qq.com/cgi-bin/tags/getidlist?access_token=";
//    设置用户备注
    public static String setUserRemarkUrl = "https://api.weixin.qq.com/cgi-bin/user/info/updateremark?access_token=";
//    获取黑名单列表
    public static String getBlackListUrl = "https://api.weixin.qq.com/cgi-bin/tags/members/getblacklist?access_token=";
//    拉黑用户
    public static String setBlackListUrl = "https://api.weixin.qq.com/cgi-bin/tags/members/batchblacklist?access_token=";
//    取消拉黑
    public static String deleteBlackListUrl = "https://api.weixin.qq.com/cgi-bin/tags/members/batchunblacklist?access_token=";
//    获取用户增减数据
    public static String getusersummaryUrl = "https://api.weixin.qq.com/datacube/getusersummary?access_token=";
//    获取累计用户数据
    public static String getusercumulateUrl = "https://api.weixin.qq.com/datacube/getusercumulate?access_token=";
//    获取图文群发每日数据
    public static String getarticlesummaryUrl = "https://api.weixin.qq.com/datacube/getarticlesummary?access_token=";
//    获取图文群发总数据
    public static String getarticletotalUrl = "https://api.weixin.qq.com/datacube/getarticletotal?access_token=";
//    获取图文统计数据
    public static String getuserreadUrl = "https://api.weixin.qq.com/datacube/getuserread?access_token=";
//    获取图文统计分时数据
    public static String getuserreadhourUrl = "https://api.weixin.qq.com/datacube/getuserreadhour?access_token=";
//    获取图文分享转发数据
    public static String getusershareUrl = "https://api.weixin.qq.com/datacube/getusershare?access_token=";
//    获取图文分享转发分时数据
    public static String getusersharehourUrl = "https://api.weixin.qq.com/datacube/getusersharehour?access_token=";
//    获取消息发送概况数据
    public static String getupstreammsgUrl = "https://api.weixin.qq.com/datacube/getupstreammsg?access_token=";
//    获取消息分送分时数据
    public static String getupstreammsghourUrl = "https://api.weixin.qq.com/datacube/getupstreammsghour?access_token=";
//    获取消息发送周数据
    public static String getupstreammsgweekUrl = "https://api.weixin.qq.com/datacube/getupstreammsgweek?access_token=";
//    获取消息发送月数据
    public static String getupstreammsgmonthUrl = "https://api.weixin.qq.com/datacube/getupstreammsgmonth?access_token=";
//    获取消息发送分布数据
    public static String getupstreammsgdistUrl = "https://api.weixin.qq.com/datacube/getupstreammsgdist?access_token=";
//    获取消息发送分布周数据
    public static String getupstreammsgdistweekUrl = "https://api.weixin.qq.com/datacube/getupstreammsgdistweek?access_token=";
//    获取消息发送分布月数据
    public static String getupstreammsgdistmonthUrl = "https://api.weixin.qq.com/datacube/getupstreammsgdistmonth?access_token=";
//    获取接口分析数据
    public static String getinterfacesummaryUrl = "https://api.weixin.qq.com/datacube/getinterfacesummary?access_token=";
//    获取接口分析分时数据
    public static String getinterfacesummaryhourUrl  = "https://api.weixin.qq.com/datacube/getinterfacesummaryhour?access_token=";
//    网页获取accessToken
    public static String getWebAccessTokenUrl = "https://api.weixin.qq.com/sns/oauth2/access_token";
//    刷新网页的accessToken
    public static String getWebAccesTokenRefreshUrl = "https://api.weixin.qq.com/sns/oauth2/refresh_token";
//    网页获取用户消息
    public static String webGetUserInfoUrl = "https://api.weixin.qq.com/sns/userinfo";
//    检验授权凭证（access_token）是否有效
    public static String checkAccessTokenUrl = "https://api.weixin.qq.com/sns/auth";

    /**
     * 检验授权凭证（access_token）是否有效
     * @return
     */
    public static String checkAccessToken(String access_token,String openid){
        HashMap<String,String> params = new HashMap<String,String>();
        params.put("access_token",access_token);
        params.put("openid",openid);
        String jsonResult = HttpUtils.get(checkAccessTokenUrl,params);
        return jsonResult;
    }
    /**
     * 网页获取用户消息
     * @return
     */
    public static String webGetUserInfo(String openid,String accessToken,String lang){
        HashMap<String,String> params = new HashMap<String,String>();
        params.put("openid",openid);
        params.put("access_token",accessToken);
        params.put("lang",lang);
        String jsonResult = HttpUtils.get(webGetUserInfoUrl,params);
        return jsonResult;
    }
    /**
     * 网页刷新accessToken
     * @return
     */
    public static String getWebAccesTokenRefresh(String wxAppId,String refresh_token){
        HashMap<String,String> params = new HashMap<String,String>();
        params.put("appid",wxAppId);
        params.put("refresh_token",refresh_token);
        params.put("grant_type","refresh_token");
        String jsonResult = HttpUtils.get(getWebAccesTokenRefreshUrl,params);
        return jsonResult;
    }
    /**
     * 网页获取accessToken
     * @return
     */
    public static String getWebAccessToken(String code,String wxAppId,String wxSecretKey){
        HashMap<String,String> params = new HashMap<String,String>();
        params.put("code",code);
        params.put("appid",wxAppId);
        params.put("secret",wxSecretKey);
        params.put("grant_type","authorization_code");
        String jsonResult = HttpUtils.get(getWebAccessTokenUrl,params);
        return jsonResult;
    }
    /**
     * 获取接口分析数据
     * @return
     */
    public static String getinterfacesummary(String access_token,String data){
        String jsonResult = HttpUtils.postJson(getinterfacesummaryUrl+access_token,data);
        return jsonResult;
    }
    /**
     * 获取接口分析分时数据
     * @return
     */
    public static String getinterfacesummaryhour(String access_token,String data){
        String jsonResult = HttpUtils.postJson(getinterfacesummaryhourUrl+access_token,data);
        return jsonResult;
    }

    /**
     * 获取消息发送分布月数据
     * @return
     */
    public static String getupstreammsgdistmonth(String access_token,String data){
        String jsonResult = HttpUtils.postJson(getupstreammsgdistmonthUrl+access_token,data);
        return jsonResult;
    }
    /**
     * 获取消息发送分布周数据
     * @return
     */
    public static String getupstreammsgdistweek(String access_token,String data){
        String jsonResult = HttpUtils.postJson(getupstreammsgdistweekUrl+access_token,data);
        return jsonResult;
    }
    /**
     * 获取消息发送分布数据
     * @return
     */
    public static String getupstreammsgdist(String access_token,String data){
        String jsonResult = HttpUtils.postJson(getupstreammsgdistUrl+access_token,data);
        return jsonResult;
    }
    /**
     * 获取消息发送月数据
     * @return
     */
    public static String getupstreammsgmonth(String access_token,String data){
        String jsonResult = HttpUtils.postJson(getupstreammsgmonthUrl+access_token,data);
        return jsonResult;
    }
    /**
     * 获取消息发送周数据
     * @return
     */
    public static String getupstreammsgweek(String access_token,String data){
        String jsonResult = HttpUtils.postJson(getupstreammsgweekUrl+access_token,data);
        return jsonResult;
    }
    /**
     * 获取消息分送分时数据
     * @return
     */
    public static String getupstreammsghour(String access_token,String data){
        String jsonResult = HttpUtils.postJson(getupstreammsghourUrl+access_token,data);
        return jsonResult;
    }
    /**
     * 获取消息发送概况数据
     * @return
     */
    public static String getupstreammsg(String access_token,String data){
        String jsonResult = HttpUtils.postJson(getupstreammsgUrl+access_token,data);
        return jsonResult;
    }
    /**
     * 获取图文分享转发分时数据
     * @return
     */
    public static String getusersharehour(String access_token,String data){
        String jsonResult = HttpUtils.postJson(getusersharehourUrl+access_token,data);
        return jsonResult;
    }
    /**
     * 获取图文分享转发数据
     * @return
     */
    public static String getusershare(String access_token,String data){
        String jsonResult = HttpUtils.postJson(getusershareUrl+access_token,data);
        return jsonResult;
    }
    /**
     * 获取图文统计分时数据
     * @return
     */
    public static String getuserreadhour(String access_token,String data){
        String jsonResult = HttpUtils.postJson(getuserreadhourUrl+access_token,data);
        return jsonResult;
    }
    /**
     * 获取图文统计数据
     * @return
     */
    public static String getuserread(String access_token,String data){
        String jsonResult = HttpUtils.postJson(getuserreadUrl+access_token,data);
        return jsonResult;
    }
    /**
     * 获取图文群发总数据
     * @return
     */
    public static String getarticletotal(String access_token,String data){
        String jsonResult = HttpUtils.postJson(getarticletotalUrl+access_token,data);
        return jsonResult;
    }
    /**
     * 获取图文群发每日数据
     * @return
     */
    public static String getarticlesummary(String access_token,String data){
        String jsonResult = HttpUtils.postJson(getarticlesummaryUrl+access_token,data);
        return jsonResult;
    }


    /**
     * 获取累计用户数据
     * @return
     */
    public static String getusercumulate(String access_token,String data){
        String jsonResult = HttpUtils.postJson(getusercumulateUrl+access_token,data);
        return jsonResult;
    }
    /**
     * 获取用户增减数据
     * @return
     */
    public static String getusersummary(String access_token,String data){
        String jsonResult = HttpUtils.postJson(getusersummaryUrl+access_token,data);
        return jsonResult;
    }
    /**
     * 取消拉黑
     * @return
     */
    public static String deleteBlackList(String access_token,String data){
        String jsonResult = HttpUtils.postJson(deleteBlackListUrl+access_token,data);
        return jsonResult;
    }
    /**
     * 拉黑用户
     * @return
     */
    public static String setBlackList(String access_token,String data){
        String jsonResult = HttpUtils.postJson(setBlackListUrl+access_token,data);
        return jsonResult;
    }
    /**
     * 获取黑名单列表
     * @return
     */
    public static String getBlackList(String access_token,String data){
        String jsonResult = HttpUtils.postJson(getBlackListUrl+access_token,data);
        return jsonResult;
    }
    /**
     * 设置用户备注
     * @return
     */
    public static String setUserRemark(String access_token,String data){
        String jsonResult = HttpUtils.postJson(setUserRemarkUrl+access_token,data);
        return jsonResult;
    }
    /**
     * 获取用户身上的标签列表
     * @return
     */
    public static String getUserTagList(String access_token,String data){
        String jsonResult = HttpUtils.postJson(getUserTagListUrl+access_token,data);
        return jsonResult;
    }

    /**
     * 批量为用户取消标签
     * @return
     */
    public static String deleteTagsBatchtagging(String access_token,String data){
        String jsonResult = HttpUtils.postJson(deleteTagsBatchtaggingUrl+access_token,data);
        return jsonResult;
    }
    /**
     * 批量为用户打标签
     * @return
     */
    public static String setTagsBatchtagging(String access_token,String data){
        String jsonResult = HttpUtils.postJson(setTagsBatchtaggingUrl+access_token,data);
        return jsonResult;
    }
    /**
     * 获取标签下粉丝列表
     * @return
     */
    public static String getTagUsers(String access_token,String data){
        String jsonResult = HttpUtils.postJson(getTagUsersUrl+access_token,data);
        return jsonResult;
    }
    /**
     * 删除标签
     * @return
     */
    public static String deleteTag(String access_token,String data){
        String jsonResult = HttpUtils.postJson(deleteTagUrl+access_token,data);
        return jsonResult;
    }
    /**
     * 修改标签
     * @return
     */
    public static String editTag(String access_token,String data){
        String jsonResult = HttpUtils.postJson(editTagUrl+access_token,data);
        return jsonResult;
    }
    /**
     * 获取标签
     * @return
     */
    public static String getTag(String access_token){
        HashMap<String,String> params = new HashMap<String,String>();
        params.put("access_token",access_token);
        String jsonResult = HttpUtils.get(getTagUrl,params);
        return jsonResult;
    }
    /**
     * 创建用户标签
     * @return
     */
    public static String createTag(String access_token,String data){
        String jsonResult = HttpUtils.postJson(createTagUrl+access_token,data);
        return jsonResult;
    }

    /**
     * 获取用户详细信息（单个获取）
     * @return
     */
    public static String getUserInfo(String access_token,String openId,String lang){
        HashMap<String,String> params = new HashMap<String,String>();
        params.put("access_token",access_token);
        params.put("openid",openId);
        params.put("lang",lang);
        String jsonResult = HttpUtils.get(getUserInfoUrl,params);
        return jsonResult;
    }
    /**
     * 获取用户详细信息（批量获取）
     * @return
     */
    public static String getUserInfoBatchge(String access_token,String data){
        String jsonResult = HttpUtils.postJson(getUserInfoBatchgetUrl+access_token,data);
        return jsonResult;
    }
    /**
     * 获取用户列表
     * @return
     */
    public static String getUserGet(String access_token,String next_openid){
        HashMap<String,String> params = new HashMap<String,String>();
        params.put("access_token",access_token);
        params.put("next_openid",next_openid);
        String jsonResult = HttpUtils.get(getUserGetUrl,params);
        return jsonResult;
    }
    /**
     * 获取accessToken
     * @return
     */
    public static String getAccessToken(String wxAppId,String wxAppSecret){
        HashMap<String,String> params = new HashMap<String,String>();
        params.put("grant_type","client_credential");
        params.put("appid",wxAppId);
        params.put("secret",wxAppSecret);
        String jsonResult = HttpUtils.get(getAccessTokenUrl,params);
        return jsonResult;
    }
}
