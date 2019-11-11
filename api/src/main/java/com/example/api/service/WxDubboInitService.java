package com.example.api.service;/*
 * @author p78o2
 * @date 2019/9/26
 */

import com.example.api.entity.vo.AccessTokenVo;

public interface WxDubboInitService {
    public AccessTokenVo getAccessToken(String wxAppId);
}
