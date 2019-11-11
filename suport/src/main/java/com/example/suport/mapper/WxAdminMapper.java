package com.example.suport.mapper;/*
 * @author p78o2
 * @date 2019/9/23
 */
import com.example.api.entity.po.PublicAccount;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WxAdminMapper {

    @Select("<script>" +"select count(*) from pulic_account where isdel = 0 "+
             "<if test='accountName != null and accountName != \"\"'>"
            + "and accountName like '%${accountName}%'"
            + "</if>"+
            "</script>" )
    int getPublicAccountCount(@Param("accountName")String accountName);

    @Select("<script>" +"select * from pulic_account where isdel = 0 "+
             "<if test='accountName != null and accountName != \"\"'>"
            + "and accountName like '%${accountName}%'"
            + "</if>"+
            "order by id desc limit #{start},#{pageSize}"+
            "</script>")
    List<PublicAccount> getPublicAccountList(@Param("accountName")String accountName,@Param("start")int start,@Param("pageSize")int pageSize);
    @Insert("insert into pulic_account (accountName,wxAppId,wxSecretKey,createUser,createTime) values " +
            "(#{p.accountName},#{p.wxAppId},#{p.wxSecretKey},#{p.createUser},#{p.createTime})")
    int insertPublicAccount(@Param("p")PublicAccount publicAccount);
    @Update("update pulic_account set accountName = #{p.accountName},wxAppId = #{p.wxAppId},wxSecretKey = #{p.wxSecretKey},modifyUser = #{p.modifyUser}" +
            ",modifyTime = #{p.modifyTime} where id = #{p.id}")
    int updatePublicAccount(@Param("p")PublicAccount publicAccount);
    @Update("update pulic_account set isdel = 1,modifyUser = #{p.modifyUser},modifyTime = #{p.modifyTime} where id = #{p.id}")
    int deletePunlicAccount(@Param("p")PublicAccount publicAccount);


}
