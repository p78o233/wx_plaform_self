package com.example.suport.service.impl.admin;/*
 * @author p78o2
 * @date 2019/9/23
 */


import com.example.api.entity.po.PublicAccount;
import com.example.suport.mapper.WxAdminMapper;
import com.example.suport.service.admin.WxAdminManageService;
import com.example.suport.utils.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class WxAdminManageServiceImpl implements WxAdminManageService{
    @Autowired
    private WxAdminMapper wxAdminMapper;
    @Override
    public PageInfo<PublicAccount> getAllWxAccount(String acountName, int page, int pageSize) {
        int start = (page-1)*pageSize;
        PageInfo pageInfo = new PageInfo(wxAdminMapper.getPublicAccountCount(acountName),wxAdminMapper.getPublicAccountList(acountName,start,pageSize));
        return pageInfo;
    }

    @Override
    public boolean ioeWxAccount(PublicAccount publicAccount) {
        if(publicAccount.getId()==null){
//            新增
            publicAccount.setCreateTime(new Date());
            if(wxAdminMapper.insertPublicAccount(publicAccount)>0)
                return true;
            return false;
        }else {
//            修改
            publicAccount.setModifyTime(new Date());
            if (wxAdminMapper.updatePublicAccount(publicAccount) > 0)
                return true;
            return false;
        }
    }

    @Override
    public boolean deleteWxAccount(int id) {
        PublicAccount pa = new PublicAccount();
        pa.setId(id);
        pa.setModifyTime(new Date());
        if(wxAdminMapper.deletePunlicAccount(pa)>0)
            return true;
        return false;
    }
}
