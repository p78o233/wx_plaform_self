package com.example.suport.controller.admin;/*
 * @author p78o2
 * @date 2019/9/23
 */

import com.example.suport.callback.R;
import com.example.api.entity.po.PublicAccount;
import com.example.suport.service.admin.WxAdminManageService;
import com.example.suport.utils.PageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/wx/admin")
@Api(description = "后台模块")
public class WxAdminManageController {
    @Autowired
    private WxAdminManageService wxAdminManageService;
    @GetMapping(value = "/getAllWxAccount")
    @ApiOperation(value = "获取全部微信账号信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="accountName",value = "公众号账号名",dataType = "String",paramType = "query",example = "p78o2的测试"),
            @ApiImplicitParam(name="page",value = "页面",dataType = "int",paramType = "query",example = "1"),
            @ApiImplicitParam(name="pageSize",value = "页码",dataType = "int",paramType = "query",example = "10")
    })
    public R<PageInfo<PublicAccount>> getAllWxAccount(@RequestParam(defaultValue = "") String accountName, @RequestParam(defaultValue = "1")int page, @RequestParam(defaultValue = "10")int pageSize){
        return new R(true,200,wxAdminManageService.getAllWxAccount(accountName,page,pageSize),"");
    }
    @PostMapping(value = "/ioeWxAccount")
    @ApiOperation(value = "新增或修改微信公众号账号")
    public R<Boolean> ioeWxAccount(@RequestBody @ApiParam(name="公众号账号信息",value="publicAccount",required=true) PublicAccount publicAccount){
        return new R<Boolean>(true,200,wxAdminManageService.ioeWxAccount(publicAccount),"");
    }
    @PostMapping(value = "/deleteWxAccount")
    @ApiOperation(value = "删除微信公众号消息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="id",value = "公众账号id",dataType = "id",paramType = "query",example = "0"),
    })
    public R<Boolean> deleteWxAccount(@RequestParam int id){
        return new R<Boolean>(true,200,wxAdminManageService.deleteWxAccount(id),"");
    }
}
