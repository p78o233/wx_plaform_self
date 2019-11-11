package com.example.suport.service.wx;/*
 * @author p78o2
 * @date 2019/9/24
 */


import com.example.api.entity.vo.AccessTokenVo;

//微信使用初始化
public interface WxInitService {
    public AccessTokenVo getAccessToken(String wxAppId);
}
