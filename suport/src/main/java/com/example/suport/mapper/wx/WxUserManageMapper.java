package com.example.suport.mapper.wx;/*
 * @author p78o2
 * @date 2019/9/26
 */

import com.example.api.entity.po.WxUserInfo;
import com.example.api.entity.po.WxUserTag;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WxUserManageMapper {
    @Insert("<script>" +
            "replace into wx_user_info (subscribe,openid,nickname,sex,city,country,province,language,headimgurl," +
            "subscribe_time,unionid,remark,groupid,tagid_list,subscribe_scene,qr_scene,qr_scene_str,wxAppId,createTime) values" +
            "<foreach collection='userInfos' item='item' index='index' separator=','>" +
            "(#{item.subscribe}, #{item.openid}, #{item.nickname},#{item.sex},#{item.city},#{item.country},#{item.province},#{item.language},#{item.headimgurl}" +
            ",#{item.subscribe_time},#{item.unionid},#{item.remark},#{item.groupid},#{item.tagid_list},#{item.subscribe_scene},#{item.qr_scene},#{item.qr_scene_str},#{item.wxAppId},#{item.createTime})" +
            "</foreach>" +
            "</script>")
    int insertUserInfotList(@Param(value = "userInfos") List<WxUserInfo> userInfos);

    @Insert("<script>" +
            "replace into wx_user_tag (tagId,name,count,wxAppId,createTime) values " +
            "<foreach collection='userTags' item='item' index='index' separator=','>" +
            "(#{item.id},#{item.name},#{item.count},#{item.wxAppId},#{item.createTime})"+
            "</foreach>" +
            "</script>")
    int insertUserTagList(@Param("userTags")List<WxUserTag> userTags);

    @Update("update wx_user_tag set name = #{w.name} where tagId = #{w.tagId} and wxAppId = #{w.wxAppId} and isdel = 0")
    int updateUserTag(@Param("w")WxUserTag wxUserTag);

    @Update("update wx_user_tag set isdel = 1 where tagId = #{tagId} and wxAppId = #{wxAppId}")
    int deleteUserTag(@Param("tagId")int tagId,@Param("wxAppId")String wxAppId);
}
