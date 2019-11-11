package com.example.suport.service.impl.wx;/*
 * @author p78o2
 * @date 2019/9/26
 */

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.api.entity.po.WxUserInfo;
import com.example.api.entity.po.WxUserTag;
import com.example.api.entity.vo.GetUserInfoListVo;
import com.example.api.entity.vo.UserGetVo;
import com.example.api.entity.vo.UserTagVo;
import com.example.suport.mapper.wx.WxUserManageMapper;
import com.example.suport.service.wx.WxInitService;
import com.example.suport.service.wx.WxUserManageService;
import com.example.suport.url.WxHttpRequest;
import com.example.suport.utils.ToolsUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class WxUserManageServiceImpl implements WxUserManageService {
    @Value("${isSaveDb}")
    private boolean isSaveDb;
    @Autowired
    private WxInitService wxInitService;
    @Autowired
    private WxUserManageMapper wxUserManageMapper;

    @Override
    public List<String> getUserOpenIds(String wxAppId, String next_openid) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            String resultStr = WxHttpRequest.getUserGet(accessToken, next_openid);
            JSONObject resultJson = JSON.parseObject(resultStr);
//            openid列表
            List<String> openIdList = new ArrayList<String>();
//                返回值的data字段
            String resultData = resultJson.getString("data");
            JSONObject resultDataObj = JSON.parseObject(resultData);
            JSONArray jsonArray = (JSONArray) resultDataObj.get("openid");
            openIdList.addAll((List<String>) JSONArray.parseArray(jsonArray.toString(), String.class));
//
            if (isSaveDb) {
                //调用获取查看用户详细功能，并保存
                if (openIdList.size() < 100) {
                    List<WxUserInfo> userInfos = new ArrayList<>();
                    userInfos = getUserInfoBatchget(wxAppId, openIdList);
//                批量插入，重复数据先删除再插入
                    wxUserManageMapper.insertUserInfotList(userInfos);
                } else {
//                    切割完成之后的新list
                    List<List<String>> newList = new ArrayList<List<String>>();
                    ToolsUtils toolsUtils = new ToolsUtils();
                    newList = toolsUtils.splitList(openIdList, 100);
                    for (int i = 0; i < newList.size(); i++) {
                        List<WxUserInfo> userInfos = new ArrayList<>();
                        userInfos = getUserInfoBatchget(wxAppId, newList.get(i));
//                批量插入，重复数据先删除再插入
                        wxUserManageMapper.insertUserInfotList(userInfos);
                    }
                }
            }
            return openIdList;
        } else {
            return null;
        }
    }

    @Override
    public WxUserInfo getUserInfo(String wxAppId, String openId, String lang) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            String resultStr = WxHttpRequest.getUserInfo(accessToken, openId, lang);
            WxUserInfo wxUserInfo = new WxUserInfo();
//            fastjson字符串转成对象
            wxUserInfo = JSON.parseObject(resultStr, WxUserInfo.class);
            return wxUserInfo;
        } else {
            return null;
        }
    }

    @Override
    public List<WxUserInfo> getUserInfoBatchget(String wxAppId, List<String> list) {
//        最多请求100个人
        if (list.size() < 100) {
            String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
//        用户详细信息列表
            List<WxUserInfo> userInfos = new ArrayList<>();
            if (accessToken != null) {
                List<GetUserInfoListVo> guiList = new ArrayList<GetUserInfoListVo>();
                for (String item : list) {
                    GetUserInfoListVo gui = new GetUserInfoListVo();
                    gui.setOpenid(item);
                    gui.setLang("zh_CN");
                    guiList.add(gui);
                }
                JSONArray arrayList = JSONArray.parseArray(JSONObject.toJSONString(guiList));
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("user_list", arrayList);
//            网络请求
                String resultStr = WxHttpRequest.getUserInfoBatchge(accessToken, jsonObject.toJSONString());
                JSONObject resultJson = JSON.parseObject(resultStr);
                String resultData = resultJson.getString("user_info_list");
                JSONArray resultDataObj = JSON.parseArray(resultData);
//                fastjson Array 转成List<Object>
                userInfos.addAll((List<WxUserInfo>) JSONArray.parseArray(resultDataObj.toString(), WxUserInfo.class));
                for (WxUserInfo userInfo : userInfos) {
                    userInfo.setWxAppId(wxAppId);
                    userInfo.setCreateTime(new Date());
                }
                return userInfos;
            } else {
                return null;
            }
        }
        return null;
    }

    @Override
    public List<WxUserTag> getUserTag(String wxAppId) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            String resultStr = WxHttpRequest.getTag(accessToken);
            JSONObject resultObj = JSON.parseObject(resultStr);
            JSONArray jsonArray = (JSONArray) resultObj.get("tags");
            List<WxUserTag> userTags = new ArrayList<WxUserTag>();
            userTags.addAll((List<WxUserTag>) JSONArray.parseArray(jsonArray.toString(), WxUserTag.class));
            for(int i=0;i<userTags.size();i++){
                userTags.get(i).setWxAppId(wxAppId);
                userTags.get(i).setCreateTime(new Date());
            }
            if (isSaveDb) {
//                保存进数据库
                wxUserManageMapper.insertUserTagList(userTags);
            }
            return userTags;
        }
        return null;
    }

    @Override
    public WxUserTag createUserTag(String wxAppId, String name) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("name", name);
            JSONObject sendObject = new JSONObject();
            sendObject.put("tag", jsonObject);

            String resultStr = WxHttpRequest.createTag(accessToken, sendObject.toJSONString());
            JSONObject resultObj = JSON.parseObject(resultStr);
            JSONObject tagJson = resultObj.getJSONObject("tag");
            WxUserTag wxUserTag = new WxUserTag();
            wxUserTag.setTagId(tagJson.getInteger("id"));
            wxUserTag.setName(tagJson.getString("name"));
            return wxUserTag;
        }
        return null;
    }

    @Override
    public boolean editUserTag(String wxAppId, WxUserTag wxUserTag) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonObj = (JSONObject) JSONObject.toJSON(wxUserTag);
            jsonObj.put("id", jsonObj.getInteger("tagId"));
            JSONObject jsonSend = new JSONObject();
            jsonSend.put("tag", jsonObj);
            String resultStr = WxHttpRequest.editTag(accessToken, jsonSend.toJSONString());
            JSONObject resultObj = JSON.parseObject(resultStr);
            if (resultObj.getInteger("errcode") == 0) {
                if (isSaveDb) {
                    WxUserTag wxUserTagUpdate = new WxUserTag();
                    wxUserTagUpdate.setTagId(jsonObj.getInteger("id"));
                    wxUserTagUpdate.setName(wxUserTag.getName());
                    wxUserTagUpdate.setWxAppId(wxAppId);
                    wxUserManageMapper.updateUserTag(wxUserTag);
                }
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean deleteUserTag(String wxAppId, int id) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("id", id);
            JSONObject jsonSend = new JSONObject();
            jsonSend.put("tag", jsonObject);
            String resultStr = WxHttpRequest.deleteTag(accessToken, jsonSend.toJSONString());
            JSONObject resultObj = JSON.parseObject(resultStr);
            if(resultObj.getInteger("errcode")==0) {
                if(isSaveDb) {
                    wxUserManageMapper.deleteUserTag(id,wxAppId);
                }
                return true;
            }else {
                return false;
            }
        }
        return false;
    }

    @Override
    public String getTagUsers(String wxAppId, int tagId, String next_openid) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonSend = new JSONObject();
            jsonSend.put("tagid",tagId);
            jsonSend.put("next_openid",next_openid);
//            网络请求
            String resultStr = WxHttpRequest.getTagUsers(accessToken,jsonSend.toJSONString());
            return resultStr;
        }
        return null;
    }

    @Override
    public boolean setTagsBatchtagging(String wxAppId, UserTagVo userTagVo) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonSend = (JSONObject)JSONObject.toJSON(userTagVo);
//            网络请求
            String resultStr = WxHttpRequest.setTagsBatchtagging(accessToken,jsonSend.toJSONString());
            JSONObject resultObj = JSON.parseObject(resultStr);
            if(resultObj.getInteger("errcode")==0)
                return true;
            return false;
        }
        return false;
    }

    @Override
    public boolean deleteTagsBatchtagging(String wxAppId, UserTagVo userTagVo) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonSend = (JSONObject)JSONObject.toJSON(userTagVo);
//            网络请求
            String resultStr = WxHttpRequest.deleteTagsBatchtagging(accessToken,jsonSend.toJSONString());
            JSONObject resultObj = JSON.parseObject(resultStr);
            if(resultObj.getInteger("errcode")==0)
                return true;
            return false;
        }
        return false;
    }

    @Override
    public String getUserTagList(String wxAppId, String openId) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonSend = new JSONObject();
            jsonSend.put("openid", openId);
//            网络请求
            String resultStr = WxHttpRequest.getUserTagList(accessToken, jsonSend.toJSONString());
            return resultStr;
        }
        return null;
    }

    @Override
    public String setUserRemark(String wxAppId, String openId, String remark) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonSend = new JSONObject();
            jsonSend.put("openid", openId);
            jsonSend.put("remark",remark);
//            网络请求
            String resultStr = WxHttpRequest.setUserRemark(accessToken, jsonSend.toJSONString());
            return resultStr;
        }
        return null;
    }

    @Override
    public String getBlackList(String wxAppId, String begin_openid) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonSend = new JSONObject();
            jsonSend.put("begin_openid", begin_openid);
//            网络请求
            String resultStr = WxHttpRequest.getBlackList(accessToken, jsonSend.toJSONString());
            return resultStr;
        }
        return null;
    }

    @Override
    public String setBlackList(String wxAppId, List<String> openIds) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonSend = new JSONObject();
            jsonSend.put("openid_list", openIds);
//            网络请求
            String resultStr = WxHttpRequest.setBlackList(accessToken, jsonSend.toJSONString());
            return resultStr;
        }
        return null;
    }

    @Override
    public String deleteBlackList(String wxAppId, List<String> openIds) {
        String accessToken = wxInitService.getAccessToken(wxAppId).getAccessToken();
        if (accessToken != null) {
            JSONObject jsonSend = new JSONObject();
            jsonSend.put("openid_list", openIds);
//            网络请求
            String resultStr = WxHttpRequest.deleteBlackList(accessToken, jsonSend.toJSONString());
            return resultStr;
        }
        return null;
    }
}
