package com.example.suport.service.wx;/*
 * @author p78o2
 * @date 2019/9/30
 */

public interface WebLoginService {
//    通过code换取网页授权access_token
    public String getWebAccessToken(String code ,String wxAppId);
//    刷新accessToken
    public String refreshAccessToken(String wxAppId,String refresh_token);
//    拉取用户信息
    public String pullUserInfo(String web_access_token,String openid,String lang);
//    检验授权凭证（access_token）是否有效
    public String checkAccessToken(String access_token,String openid);
}
