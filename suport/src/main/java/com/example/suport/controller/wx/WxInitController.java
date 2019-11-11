package com.example.suport.controller.wx;/*
 * @author p78o2
 * @date 2019/9/25
 */

import com.example.suport.callback.R;
import com.example.api.entity.po.PublicAccount;
import com.example.suport.service.admin.WxAdminManageService;
import com.example.suport.service.wx.WxInitService;
import com.example.suport.utils.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx/init")
@Api(description = "初始化模块")
public class WxInitController {
    @Autowired
    private WxInitService wxInitService;
    @GetMapping(value = "/getUserOpenIds")
    @ApiOperation(value = "获取微信accessToken")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query")
    })
    public void getAllWxAccount(@RequestParam(defaultValue = "") String wxAppId){
       wxInitService.getAccessToken(wxAppId);
    }
}
