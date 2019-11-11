package com.example.suport.controller.wx;/*
 * @author p78o2
 * @date 2019/9/27
 */

import com.example.api.entity.po.WxUserInfo;
import com.example.api.entity.po.WxUserTag;
import com.example.api.entity.vo.UserTagVo;
import com.example.suport.callback.R;
import com.example.suport.service.wx.WxUserManageService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/wx/user-manage")
@Api(description = "用户管理模块")
public class WxUserManageController {
    @Autowired
    private WxUserManageService wxUserManageService;
    @GetMapping(value = "/getUserOpenIds")
    @ApiOperation(value = "根据微信appid获取openid列表，最多一次10000个")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="next_openid",value = "上一次最后一个openid，不填默认从第一个开始",dataType = "String",paramType = "query")
    })
    public R<List<String>> getUserOpenIds(@RequestParam(defaultValue = "") String wxAppId, @RequestParam(defaultValue = "")String next_openid){
        return new R<List<String>>(true,200,wxUserManageService.getUserOpenIds(wxAppId,next_openid),"");
    }
    @GetMapping(value = "/getUserInfo")
    @ApiOperation(value = "根据opeid获取一个用户详细信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="openid",value = "用户openid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="lang",value = "返回国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语",dataType = "String",paramType = "query")
    })
    public R<WxUserInfo> getUserInfo(@RequestParam String wxAppId, @RequestParam String openid,@RequestParam(defaultValue = "zh_CN")String lang){
        return new R<WxUserInfo>(true,200,wxUserManageService.getUserInfo(wxAppId,openid,lang),"");
    }
    @PostMapping(value = "/getUserInfoBatchget/{wxAppId}")
    @ApiOperation(value = "根据opeid列表获取批量用户详细信息，最多一次100个")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "path")
    })
    public R<List<WxUserInfo>> getUserInfoBatchget(@PathParam("wxAppId")String wxAppId, @RequestBody @ApiParam(name="微信id列表",value="list",required=true) List<String>list){
        return new R<List<WxUserInfo>>(true,200,wxUserManageService.getUserInfoBatchget(wxAppId,list),"");
    }
    @GetMapping(value = "/getUserTag")
    @ApiOperation(value = "获取公众号创建的标签")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query")
    })
    public R<List<WxUserTag>> getUserInfoBatchget(@RequestParam String wxAppId){
        return new R<List<WxUserTag>>(true,200,wxUserManageService.getUserTag(wxAppId),"");
    }
    @PostMapping(value = "/createUserTag")
    @ApiOperation(value = "创建公众号的标签")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="name",value = "标签名30个字符内",dataType = "String",paramType = "query")
    })
    public R<WxUserTag> createUserTag(@RequestParam String wxAppId,@RequestParam String name){
        return new R<WxUserTag>(true,200,wxUserManageService.createUserTag(wxAppId,name),"");
    }
    @PostMapping(value = "/editUserTag/{wxAppId}")
    @ApiOperation(value = "修改公众号的标签")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "path"),
    })
    public R<Boolean> editUserTag(@PathVariable("wxAppId")String wxAppId,@RequestBody @ApiParam(name="用户标签",value="wxUserTag",required=true) WxUserTag wxUserTag){
        return new R<Boolean>(true,200,wxUserManageService.editUserTag(wxAppId,wxUserTag),"");
    }
    @PostMapping(value = "/deleteUserTag")
    @ApiOperation(value = "删除公众号的标签")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="tagId",value = "标签id",dataType = "Integer",paramType = "query")
    })
    public R<Boolean> createUserTag(@RequestParam String wxAppId,@RequestParam int tagId){
        return new R<Boolean>(true,200,wxUserManageService.deleteUserTag(wxAppId,tagId),"");
    }
    @GetMapping(value = "/getTagUsers")
    @ApiOperation(value = "获取标签下粉丝openid列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="tagId",value = "标签id",dataType = "Integer",paramType = "query"),
            @ApiImplicitParam(name="next_openid",value = "上一个查询最后一个openid，不传从第一个开始",dataType = "Integer",paramType = "query")
    })
    public R<String> getTagUsers(@RequestParam String wxAppId,@RequestParam int tagId,@RequestParam(defaultValue = "")String next_openid){
        return new R<String>(true,200,wxUserManageService.getTagUsers(wxAppId,tagId,next_openid),"");
    }
    @PostMapping(value = "/setTagsBatchtagging/{wxAppId}")
    @ApiOperation("/为用户批量打上标签")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "path")
    })
    public R<Boolean> setTagsBatchtagging(@PathVariable("wxAppId")String wxAppId,@RequestBody @ApiParam(name="批量处理用户标签",value="userTagVo",required=true) UserTagVo userTagVo){
        return new R<Boolean>(true,200,wxUserManageService.setTagsBatchtagging(wxAppId,userTagVo),"");
    }
    @PostMapping(value = "/deleteTagsBatchtagging/{wxAppId}")
    @ApiOperation("/为用户批量删除标签")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "path")
    })
    public R<Boolean> deleteTagsBatchtagging(@PathVariable("wxAppId")String wxAppId,@RequestBody @ApiParam(name="批量处理用户标签",value="userTagVo",required=true) UserTagVo userTagVo){
        return new R<Boolean>(true,200,wxUserManageService.deleteTagsBatchtagging(wxAppId,userTagVo),"");
    }
    @GetMapping(value = "/getUserTagList")
    @ApiOperation(value = "获取用户标签列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="openId",value = "用户openid",dataType = "String",paramType = "query"),
    })
    public R<String> getUserTagList(@RequestParam String wxAppId,@RequestParam String openId){
        return new R<String>(true,200,wxUserManageService.getUserTagList(wxAppId,openId),"");
    }
    @PostMapping(value = "/setUserRemark")
    @ApiOperation(value = "设置用户备注姓名")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="openId",value = "用户openid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="remark",value = "备注",dataType = "String",paramType = "query")
    })
    public R<String> setUserRemark(@RequestParam String wxAppId,@RequestParam String openId,@RequestParam String remark){
        return new R<String>(true,200,wxUserManageService.setUserRemark(wxAppId,openId,remark),"");
    }
    @GetMapping(value = "/getBlackList")
    @ApiOperation(value = "获取公众号黑名单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "query"),
            @ApiImplicitParam(name="begin_openid",value = "最后一个openid，不填默认从第一个开始",dataType = "String",paramType = "query")
    })
    public R<String> getBlackList(@RequestParam String wxAppId,@RequestParam(defaultValue = "") String begin_openid ){
        return new R<String>(true,200,wxUserManageService.getBlackList(wxAppId,begin_openid),"");
    }
    @PostMapping(value = "/setBlackList/{wxAppId}")
    @ApiOperation(value = "拉黑用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "path")
    })
    public R<String> setBlackList(@PathVariable("wxAppId")String wxAppId,@RequestBody @ApiParam(name="openid列表，一次最多20个",value="openIds",required=true)List<String>openIds){
        return new R<String>(true,200,wxUserManageService.setBlackList(wxAppId,openIds),"");
    }
    @PostMapping(value = "/deleteBlackList/{wxAppId}")
    @ApiOperation(value = "取消拉黑用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name="wxAppId",value = "微信appid",dataType = "String",paramType = "path")
    })
    public R<String> deleteBlackList(@PathVariable("wxAppId")String wxAppId,@RequestBody @ApiParam(name="openid列表，一次最多20个",value="openIds",required=true)List<String>openIds){
        return new R<String>(true,200,wxUserManageService.deleteBlackList(wxAppId,openIds),"");
    }
}
