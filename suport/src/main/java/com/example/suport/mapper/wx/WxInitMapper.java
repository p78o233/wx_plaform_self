package com.example.suport.mapper.wx;/*
 * @author p78o2
 * @date 2019/9/25
 */

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface WxInitMapper {
    @Select("select ifnull(wxSecretKey,'') from pulic_account where wxAppId = #{wxAppId}")
    String getWxSecretKey(@Param("wxAppId")String wxAppId);
}
