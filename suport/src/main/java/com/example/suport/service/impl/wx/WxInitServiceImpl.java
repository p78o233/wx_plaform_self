package com.example.suport.service.impl.wx;/*
 * @author p78o2
 * @date 2019/9/24
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.api.entity.vo.AccessTokenVo;
import com.example.suport.mapper.wx.WxInitMapper;
import com.example.suport.service.wx.WxInitService;
import com.example.suport.url.WxHttpRequest;
import com.example.suport.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxInitServiceImpl implements WxInitService {
    @Autowired
    private WxInitMapper wxInitMapper;
    @Override
    public AccessTokenVo getAccessToken(String wxAppId) {
//        先去redis拿，如果redis中没有就去网络请求
        RedisUtil redisUtil = new RedisUtil();
        AccessTokenVo atv = new AccessTokenVo();
        if(redisUtil.hasKey(wxAppId+"_accessToken")){
            atv.setAccessToken((String) redisUtil.get(wxAppId+"_accessToken"));
            atv.setExpiresIn((long)redisUtil.getExpire(wxAppId+"_accessToken"));
            return atv;
        }else{
//            根据wxAppId获取wxAppSercet
            String wxAppSecret = wxInitMapper.getWxSecretKey(wxAppId);
            if(wxAppSecret!=null) {
                String resultsStr = WxHttpRequest.getAccessToken(wxAppId, wxAppSecret);
                JSONObject resultJson = JSON.parseObject(resultsStr);
                redisUtil.set(wxAppId + "_accessToken", resultJson.getString("access_token"), resultJson.getInteger("expires_in"));
                atv.setAccessToken(resultJson.getString("access_token"));
                atv.setExpiresIn(resultJson.getInteger("expires_in"));
                return atv;
            }else{
                return null;
            }
        }
    }
}
