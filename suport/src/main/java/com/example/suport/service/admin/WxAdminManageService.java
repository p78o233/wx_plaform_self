package com.example.suport.service.admin;/*
 * @author p78o2
 * @date 2019/9/23
 */

import com.example.suport.utils.PageInfo;
import com.example.api.entity.po.PublicAccount;

//后台管理service
public interface WxAdminManageService {
//    根据公众号名获取公众号信息
    public PageInfo<PublicAccount> getAllWxAccount(String acountName, int page, int pageSize);
//    新增或者修改公众号
    public boolean ioeWxAccount(PublicAccount publicAccount);
//    删除公众号信息
    public boolean deleteWxAccount(int id);
}
