package com.example.suport.controller.wx;/*
 * @author p78o2
 * @date 2019/9/30
 */

import com.example.suport.callback.R;
import com.example.suport.service.wx.WebLoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wx/web-login")
@Api(description = "公众号网页授权模块")
public class WebLoginController {
    @Autowired
    private WebLoginService webLoginService;
    @GetMapping(value = "/getWebAccessToken")
    @ApiOperation(value = "使用code换accessToken")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "公众号的唯一标识",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="code",value = "填写第一步获取的code参数",dataType = "String",paramType = "query")
    })
    public R<String> getusersummary(@RequestParam String wxAppId, @RequestParam String code){
        return new R<String>(true,200,webLoginService.getWebAccessToken(wxAppId,code),"");
    }
    @GetMapping(value = "/refreshAccessToken")
    @ApiOperation(value = "刷新accessToken")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "公众号的唯一标识",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="refresh_token",value = "获取accessToken的时候的refresh_token",dataType = "String",paramType = "query")
    })
    public R<String> refreshAccessToken(@RequestParam String wxAppId, @RequestParam String refresh_token){
        return new R<String>(true,200,webLoginService.refreshAccessToken(wxAppId,refresh_token),"");
    }
    @GetMapping(value = "/pullUserInfo")
    @ApiOperation(value = "拉取用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="accessToken",value = "accessToken",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="openid",value = "用户唯一标识",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="lang",value = "返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语",dataType = "String",paramType = "query")
    })
    public R<String> pullUserInfo(@RequestParam String accessToken, @RequestParam String openid,@RequestParam String lang){
        return new R<String>(true,200,webLoginService.pullUserInfo(accessToken,openid,lang),"");
    }
    @GetMapping(value = "/checkAccessToken")
    @ApiOperation(value = "检查accessToken是否有效")
    @ApiImplicitParams({
            @ApiImplicitParam(name="accessToken",value = "accessToken",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="openid",value = "用户唯一标识",dataType = "String",paramType = "query")
    })
    public R<String> checkAccessToken(@RequestParam String accessToken, @RequestParam String openid){
        return new R<String>(true,200,webLoginService.checkAccessToken(accessToken,openid),"");
    }
}
