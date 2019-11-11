package com.example.suport.mapper.wx;/*
 * @author p78o2
 * @date 2019/9/30
 */

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface WxLoginMapper {
    @Select("select wxSecretKey from pulic_account where wxAppId = #{wxAppId} and isdel = 0")
    String getWxSecretKey(@Param("wxAppId")String wxAppId);
}
