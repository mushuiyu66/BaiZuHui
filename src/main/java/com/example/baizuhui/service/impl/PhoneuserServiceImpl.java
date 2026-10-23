package com.example.baizuhui.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.baizuhui.domain.AdminUsers;
import com.example.baizuhui.domain.Phoneuser;
import com.example.baizuhui.service.PhoneuserService;
import com.example.baizuhui.mapper.PhoneuserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author LENOVO
* @description 针对表【phoneuser(手机登录用户表)】的数据库操作Service实现
* @createDate 2025-06-26 09:20:41
*/
@Service
public class PhoneuserServiceImpl extends ServiceImpl<PhoneuserMapper, Phoneuser>
    implements PhoneuserService{
@Resource
    private PhoneuserMapper phoneuserMapper;

    @Override
    public boolean savePhoneUser(Phoneuser phoneuser) {
        boolean savePhoneUser = phoneuserMapper.savePhoneUser(phoneuser);
        return savePhoneUser;
    }

    @Override
    public List<Phoneuser> FindAll() {
        List<Phoneuser> FindAll=phoneuserMapper.FindAll();
        return FindAll;
    }

    @Override
    public boolean dynamicUpdatePhoneUser(Phoneuser phoneuser) {
        int rows=phoneuserMapper.dynamicUpdatePhoneUser(phoneuser);
        return rows>0;
    }

    @Override
    public boolean deleteByUserId(Long userid) {
        if(userid==null){
            return false;
        }
        phoneuserMapper.deleteByUserId(userid);
        return true;
    }
}




