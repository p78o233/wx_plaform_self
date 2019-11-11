package com.example.suport.controller.wx;/*
 * @author p78o2
 * @date 2019/9/29
 */

import com.example.suport.callback.R;
import com.example.suport.service.wx.WxDataSumService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/wx/data-sum")
@Api(description = "数据统计模块")
public class WxDataSumController {
    @Autowired
    private WxDataSumService wxDataSumService;
    @PostMapping(value = "/getusersummary")
    @ApiOperation(value = "获取用户增减数据,时间跨度7天")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="begin_date",value = "起始时间，格式2014-12-07",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="end_date",value = "结束时间，格式2014-12-07",dataType = "String",paramType = "query")
    })
    public R<String> getusersummary(@RequestParam String wxAppId,@RequestParam String begin_date,@RequestParam String end_date){
        return new R<String>(true,200,wxDataSumService.getusersummary(wxAppId,begin_date,end_date),"");
    }
    @PostMapping(value = "/getusercumulate")
    @ApiOperation(value = "获取累计用户数据,时间跨度7天")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="begin_date",value = "起始时间，格式2014-12-07",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="end_date",value = "结束时间，格式2014-12-07",dataType = "String",paramType = "query")
    })
    public R<String> getusercumulate(@RequestParam String wxAppId,@RequestParam String begin_date,@RequestParam String end_date){
        return new R<String>(true,200,wxDataSumService.getusercumulate(wxAppId,begin_date,end_date),"");
    }
    @PostMapping(value = "/getarticlesummary")
    @ApiOperation(value = "获取图文群发每日数据,时间跨度1天")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="begin_date",value = "起始时间，格式2014-12-07",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="end_date",value = "结束时间，格式2014-12-07",dataType = "String",paramType = "query")
    })
    public R<String> getarticlesummary(@RequestParam String wxAppId,@RequestParam String begin_date,@RequestParam String end_date){
        return new R<String>(true,200,wxDataSumService.getarticlesummary(wxAppId,begin_date,end_date),"");
    }
    @PostMapping(value = "/getarticletotal")
    @ApiOperation(value = "获取图文群发总数据,时间跨度1天")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="begin_date",value = "起始时间，格式2014-12-07",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="end_date",value = "结束时间，格式2014-12-07",dataType = "String",paramType = "query")
    })
    public R<String> getarticletotal(@RequestParam String wxAppId,@RequestParam String begin_date,@RequestParam String end_date){
        return new R<String>(true,200,wxDataSumService.getarticletotal(wxAppId,begin_date,end_date),"");
    }
    @PostMapping(value = "/getuserread")
    @ApiOperation(value = "获取图文统计数据,时间跨度3天")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="begin_date",value = "起始时间，格式2014-12-07",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="end_date",value = "结束时间，格式2014-12-07",dataType = "String",paramType = "query")
    })
    public R<String> getuserread(@RequestParam String wxAppId,@RequestParam String begin_date,@RequestParam String end_date){
        return new R<String>(true,200,wxDataSumService.getuserread(wxAppId,begin_date,end_date),"");
    }
    @PostMapping(value = "/getuserreadhour")
    @ApiOperation(value = "获取图文分享转发数据,时间跨度7天")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="begin_date",value = "起始时间，格式2014-12-07",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="end_date",value = "结束时间，格式2014-12-07",dataType = "String",paramType = "query")
    })
    public R<String> getuserreadhour(@RequestParam String wxAppId,@RequestParam String begin_date,@RequestParam String end_date){
        return new R<String>(true,200,wxDataSumService.getuserreadhour(wxAppId,begin_date,end_date),"");
    }
    @PostMapping(value = "/getusershare")
    @ApiOperation(value = "获取图文分享转发数据,时间跨度7天")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="begin_date",value = "起始时间，格式2014-12-07",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="end_date",value = "结束时间，格式2014-12-07",dataType = "String",paramType = "query")
    })
    public R<String> getusershare(@RequestParam String wxAppId,@RequestParam String begin_date,@RequestParam String end_date){
        return new R<String>(true,200,wxDataSumService.getusershare(wxAppId,begin_date,end_date),"");
    }
    @PostMapping(value = "/getusersharehour")
    @ApiOperation(value = "获取图文分享转发分时数据,时间跨度1天")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="begin_date",value = "起始时间，格式2014-12-07",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="end_date",value = "结束时间，格式2014-12-07",dataType = "String",paramType = "query")
    })
    public R<String> getusersharehour(@RequestParam String wxAppId,@RequestParam String begin_date,@RequestParam String end_date){
        return new R<String>(true,200,wxDataSumService.getusersharehour(wxAppId,begin_date,end_date),"");
    }
    @PostMapping(value = "/getupstreammsg")
    @ApiOperation(value = "获取消息发送概况数据,时间跨度7天")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="begin_date",value = "起始时间，格式2014-12-07",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="end_date",value = "结束时间，格式2014-12-07",dataType = "String",paramType = "query")
    })
    public R<String> getupstreammsg(@RequestParam String wxAppId,@RequestParam String begin_date,@RequestParam String end_date){
        return new R<String>(true,200,wxDataSumService.getupstreammsg(wxAppId,begin_date,end_date),"");
    }
    @PostMapping(value = "/getupstreammsghour")
    @ApiOperation(value = "获取消息分送分时数据,时间跨度1天")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="begin_date",value = "起始时间，格式2014-12-07",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="end_date",value = "结束时间，格式2014-12-07",dataType = "String",paramType = "query")
    })
    public R<String> getupstreammsghour(@RequestParam String wxAppId,@RequestParam String begin_date,@RequestParam String end_date){
        return new R<String>(true,200,wxDataSumService.getupstreammsghour(wxAppId,begin_date,end_date),"");
    }
    @PostMapping(value = "/getupstreammsgweek")
    @ApiOperation(value = "获取消息发送周数据,时间跨度30天")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="begin_date",value = "起始时间，格式2014-12-07",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="end_date",value = "结束时间，格式2014-12-07",dataType = "String",paramType = "query")
    })
    public R<String> getupstreammsgweek(@RequestParam String wxAppId,@RequestParam String begin_date,@RequestParam String end_date){
        return new R<String>(true,200,wxDataSumService.getupstreammsgweek(wxAppId,begin_date,end_date),"");
    }
    @PostMapping(value = "/getupstreammsgmonth")
    @ApiOperation(value = "获取消息发送月数据,时间跨度30天")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="begin_date",value = "起始时间，格式2014-12-07",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="end_date",value = "结束时间，格式2014-12-07",dataType = "String",paramType = "query")
    })
    public R<String> getupstreammsgmonth(@RequestParam String wxAppId,@RequestParam String begin_date,@RequestParam String end_date){
        return new R<String>(true,200,wxDataSumService.getupstreammsgmonth(wxAppId,begin_date,end_date),"");
    }
    @PostMapping(value = "/getupstreammsgdist")
    @ApiOperation(value = "获取消息发送分布数据,时间跨度15天")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="begin_date",value = "起始时间，格式2014-12-07",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="end_date",value = "结束时间，格式2014-12-07",dataType = "String",paramType = "query")
    })
    public R<String> getupstreammsgdist(@RequestParam String wxAppId,@RequestParam String begin_date,@RequestParam String end_date){
        return new R<String>(true,200,wxDataSumService.getupstreammsgdist(wxAppId,begin_date,end_date),"");
    }
    @PostMapping(value = "/getupstreammsgdistweek")
    @ApiOperation(value = "获取消息发送分布周数据,时间跨度30天")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="begin_date",value = "起始时间，格式2014-12-07",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="end_date",value = "结束时间，格式2014-12-07",dataType = "String",paramType = "query")
    })
    public R<String> getupstreammsgdistweek(@RequestParam String wxAppId,@RequestParam String begin_date,@RequestParam String end_date){
        return new R<String>(true,200,wxDataSumService.getupstreammsgdistweek(wxAppId,begin_date,end_date),"");
    }
    @PostMapping(value = "/getupstreammsgdistmonth")
    @ApiOperation(value = "获取消息发送分布月数据,时间跨度30天")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="begin_date",value = "起始时间，格式2014-12-07",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="end_date",value = "结束时间，格式2014-12-07",dataType = "String",paramType = "query")
    })
    public R<String> getupstreammsgdistmonth(@RequestParam String wxAppId,@RequestParam String begin_date,@RequestParam String end_date){
        return new R<String>(true,200,wxDataSumService.getupstreammsgdistmonth(wxAppId,begin_date,end_date),"");
    }
    @PostMapping(value = "/getinterfacesummary")
    @ApiOperation(value = "获取接口分析数据,时间跨度30天")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="begin_date",value = "起始时间，格式2014-12-07",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="end_date",value = "结束时间，格式2014-12-07",dataType = "String",paramType = "query")
    })
    public R<String> getinterfacesummary(@RequestParam String wxAppId,@RequestParam String begin_date,@RequestParam String end_date){
        return new R<String>(true,200,wxDataSumService.getinterfacesummary(wxAppId,begin_date,end_date),"");
    }
    @PostMapping(value = "/getinterfacesummaryhour")
    @ApiOperation(value = "获取接口分析分时数据,时间跨度1天")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="begin_date",value = "起始时间，格式2014-12-07",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="end_date",value = "结束时间，格式2014-12-07",dataType = "String",paramType = "query")
    })
    public R<String> getinterfacesummaryhour(@RequestParam String wxAppId,@RequestParam String begin_date,@RequestParam String end_date){
        return new R<String>(true,200,wxDataSumService.getinterfacesummaryhour(wxAppId,begin_date,end_date),"");
    }
}
