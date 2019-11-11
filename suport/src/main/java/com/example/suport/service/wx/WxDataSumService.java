package com.example.suport.service.wx;/*
 * @author p78o2
 * @date 2019/9/29
 */
//数据统计模块
public interface WxDataSumService {
//    用户分析
//    获取用户增减数据7
    public String getusersummary(String wxAppId,String begin_date,String end_date);
//    获取累计用户数据7
    public String getusercumulate(String wxAppId,String begin_date,String end_date);

//    图文分析
//    获取图文群发每日数据1
    public String getarticlesummary(String wxAppId,String begin_date,String end_date);
//    获取图文群发总数据1
    public String getarticletotal(String wxAppId,String begin_date,String end_date);
//    获取图文统计数据3
    public String getuserread(String wxAppId,String begin_date,String end_date);
//    获取图文统计分时数据1
    public String getuserreadhour(String wxAppId,String begin_date,String end_date);
//    获取图文分享转发数据7
    public String getusershare(String wxAppId,String begin_date,String end_date);
//    获取图文分享转发分时数据1
    public String getusersharehour(String wxAppId,String begin_date,String end_date);

//    消息分析
//    获取消息发送概况数据7
    public String getupstreammsg(String wxAppId,String begin_date,String end_date);
//    获取消息分送分时数据1
    public String getupstreammsghour(String wxAppId,String begin_date,String end_date);
//    获取消息发送周数据30
    public String getupstreammsgweek(String wxAppId,String begin_date,String end_date);
//    获取消息发送月数据30
    public String getupstreammsgmonth(String wxAppId,String begin_date,String end_date);
//    获取消息发送分布数据15
    public String getupstreammsgdist(String wxAppId,String begin_date,String end_date);
//    获取消息发送分布周数据30
    public String getupstreammsgdistweek(String wxAppId,String begin_date,String end_date);
//    获取消息发送分布月数据30
    public String getupstreammsgdistmonth(String wxAppId,String begin_date,String end_date);

//    接口分析
//    获取接口分析数据30
    public String getinterfacesummary(String wxAppId,String begin_date,String end_date);
//    获取接口分析分时数据1
    public String getinterfacesummaryhour(String wxAppId,String begin_date,String end_date);
}
