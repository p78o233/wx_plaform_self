package com.example.suport.service.dubbo.wx;/*
 * @author p78o2
 * @date 2019/9/26
 */

import com.alibaba.dubbo.config.annotation.Service;
import com.example.api.entity.vo.AccessTokenVo;
import com.example.api.service.WxDubboInitService;
import com.example.suport.service.wx.WxInitService;
import org.springframework.beans.factory.annotation.Autowired;

@Service(version = "1.0.0")
public class WxDubboInitServiceImpl implements WxDubboInitService {
    @Autowired
    private WxInitService wxInitService;
    @Override
    public AccessTokenVo getAccessToken(String wxAppId) {
        return wxInitService.getAccessToken(wxAppId);
    }
}
