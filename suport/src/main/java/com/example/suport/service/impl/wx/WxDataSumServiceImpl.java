package com.example.suport.service.impl.wx;/*
 * @author p78o2
 * @date 2019/9/29
 */

import com.alibaba.fastjson.JSONObject;
import com.example.suport.mapper.wx.WxDataSumMapper;
import com.example.suport.service.wx.WxDataSumService;
import com.example.suport.service.wx.WxInitService;
import com.example.suport.url.WxHttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class WxDataSumServiceImpl implements WxDataSumService {
    @Value("${isSaveDb}")
    private boolean isSaveDb;
    @Autowired
    private WxInitService wxInitService;
    @Autowired
    private WxDataSumMapper wxDataSumMapper;
    @Override
    public String getusersummary(String wxAppId, String begin_date, String end_date) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonSend = new JSONObject();
            jsonSend.put("begin_date",begin_date);
            jsonSend.put("end_date",end_date);
            String resultStr = WxHttpRequest.getusersummary(accessToken,jsonSend.toJSONString());
            return resultStr;
        }
        return null;
    }

    @Override
    public String getusercumulate(String wxAppId, String begin_date, String end_date) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonSend = new JSONObject();
            jsonSend.put("begin_date",begin_date);
            jsonSend.put("end_date",end_date);
            String resultStr = WxHttpRequest.getusercumulate(accessToken,jsonSend.toJSONString());
            return resultStr;
        }
        return null;
    }

    @Override
    public String getarticlesummary(String wxAppId, String begin_date, String end_date) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonSend = new JSONObject();
            jsonSend.put("begin_date",begin_date);
            jsonSend.put("end_date",end_date);
            String resultStr = WxHttpRequest.getarticlesummary(accessToken,jsonSend.toJSONString());
            return resultStr;
        }
        return null;
    }

    @Override
    public String getarticletotal(String wxAppId, String begin_date, String end_date) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonSend = new JSONObject();
            jsonSend.put("begin_date",begin_date);
            jsonSend.put("end_date",end_date);
            String resultStr = WxHttpRequest.getarticletotal(accessToken,jsonSend.toJSONString());
            return resultStr;
        }
        return null;
    }

    @Override
    public String getuserread(String wxAppId, String begin_date, String end_date) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonSend = new JSONObject();
            jsonSend.put("begin_date",begin_date);
            jsonSend.put("end_date",end_date);
            String resultStr = WxHttpRequest.getuserread(accessToken,jsonSend.toJSONString());
            return resultStr;
        }
        return null;
    }

    @Override
    public String getuserreadhour(String wxAppId, String begin_date, String end_date) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonSend = new JSONObject();
            jsonSend.put("begin_date",begin_date);
            jsonSend.put("end_date",end_date);
            String resultStr = WxHttpRequest.getuserreadhour(accessToken,jsonSend.toJSONString());
            return resultStr;
        }
        return null;
    }

    @Override
    public String getusershare(String wxAppId, String begin_date, String end_date) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonSend = new JSONObject();
            jsonSend.put("begin_date",begin_date);
            jsonSend.put("end_date",end_date);
            String resultStr = WxHttpRequest.getusershare(accessToken,jsonSend.toJSONString());
            return resultStr;
        }
        return null;
    }

    @Override
    public String getusersharehour(String wxAppId, String begin_date, String end_date) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonSend = new JSONObject();
            jsonSend.put("begin_date",begin_date);
            jsonSend.put("end_date",end_date);
            String resultStr = WxHttpRequest.getusersharehour(accessToken,jsonSend.toJSONString());
            return resultStr;
        }
        return null;
    }

    @Override
    public String getupstreammsg(String wxAppId, String begin_date, String end_date) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonSend = new JSONObject();
            jsonSend.put("begin_date",begin_date);
            jsonSend.put("end_date",end_date);
            String resultStr = WxHttpRequest.getupstreammsg(accessToken,jsonSend.toJSONString());
            return resultStr;
        }
        return null;
    }

    @Override
    public String getupstreammsghour(String wxAppId, String begin_date, String end_date) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonSend = new JSONObject();
            jsonSend.put("begin_date",begin_date);
            jsonSend.put("end_date",end_date);
            String resultStr = WxHttpRequest.getupstreammsghour(accessToken,jsonSend.toJSONString());
            return resultStr;
        }
        return null;
    }

    @Override
    public String getupstreammsgweek(String wxAppId, String begin_date, String end_date) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonSend = new JSONObject();
            jsonSend.put("begin_date",begin_date);
            jsonSend.put("end_date",end_date);
            String resultStr = WxHttpRequest.getupstreammsgweek(accessToken,jsonSend.toJSONString());
            return resultStr;
        }
        return null;
    }

    @Override
    public String getupstreammsgmonth(String wxAppId, String begin_date, String end_date) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonSend = new JSONObject();
            jsonSend.put("begin_date",begin_date);
            jsonSend.put("end_date",end_date);
            String resultStr = WxHttpRequest.getupstreammsgmonth(accessToken,jsonSend.toJSONString());
            return resultStr;
        }
        return null;
    }

    @Override
    public String getupstreammsgdist(String wxAppId, String begin_date, String end_date) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonSend = new JSONObject();
            jsonSend.put("begin_date",begin_date);
            jsonSend.put("end_date",end_date);
            String resultStr = WxHttpRequest.getupstreammsgdist(accessToken,jsonSend.toJSONString());
            return resultStr;
        }
        return null;
    }

    @Override
    public String getupstreammsgdistweek(String wxAppId, String begin_date, String end_date) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonSend = new JSONObject();
            jsonSend.put("begin_date",begin_date);
            jsonSend.put("end_date",end_date);
            String resultStr = WxHttpRequest.getupstreammsgdistweek(accessToken,jsonSend.toJSONString());
            return resultStr;
        }
        return null;
    }

    @Override
    public String getupstreammsgdistmonth(String wxAppId, String begin_date, String end_date) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonSend = new JSONObject();
            jsonSend.put("begin_date",begin_date);
            jsonSend.put("end_date",end_date);
            String resultStr = WxHttpRequest.getupstreammsgdistmonth(accessToken,jsonSend.toJSONString());
            return resultStr;
        }
        return null;
    }

    @Override
    public String getinterfacesummary(String wxAppId, String begin_date, String end_date) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonSend = new JSONObject();
            jsonSend.put("begin_date",begin_date);
            jsonSend.put("end_date",end_date);
            String resultStr = WxHttpRequest.getinterfacesummary(accessToken,jsonSend.toJSONString());
            return resultStr;
        }
        return null;
    }

    @Override
    public String getinterfacesummaryhour(String wxAppId, String begin_date, String end_date) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonSend = new JSONObject();
            jsonSend.put("begin_date",begin_date);
            jsonSend.put("end_date",end_date);
            String resultStr = WxHttpRequest.getinterfacesummaryhour(accessToken,jsonSend.toJSONString());
            return resultStr;
        }
        return null;
    }
}
