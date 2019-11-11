package com.example.suport.service.impl.wx;/*
 * @author p78o2
 * @date 2019/9/30
 */

import com.example.suport.mapper.wx.WxLoginMapper;
import com.example.suport.service.wx.WebLoginService;
import com.example.suport.url.WxHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebLoginServiceImpl implements WebLoginService {
    @Autowired
    private WxLoginMapper wxLoginMapper;
    @Override
    public String getWebAccessToken(String code, String wxAppId) {
        String wxSecretKey = wxLoginMapper.getWxSecretKey(wxAppId);
        if(wxSecretKey!=null){
            String resultStr = WxHttpRequest.getWebAccessToken(code,wxAppId,wxSecretKey);
            return resultStr;
        }
        return null;
    }

    @Override
    public String refreshAccessToken(String wxAppId, String refresh_token) {
        String resultStr = WxHttpRequest.getWebAccesTokenRefresh(wxAppId,refresh_token);
        return resultStr;
    }

    @Override
    public String pullUserInfo(String web_access_token, String openid, String lang) {
        String resultStr = WxHttpRequest.webGetUserInfo(openid,web_access_token,lang);
        return resultStr;
    }

    @Override
    public String checkAccessToken(String access_token, String openid) {
        String resultStr = WxHttpRequest.checkAccessToken(access_token,openid);
        return resultStr;
    }
}
