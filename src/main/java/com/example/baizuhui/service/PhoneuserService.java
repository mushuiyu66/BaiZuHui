package com.example.baizuhui.service;

import com.example.baizuhui.domain.AdminUsers;
import com.example.baizuhui.domain.Phoneuser;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author LENOVO
* @description 针对表【phoneuser(手机登录用户表)】的数据库操作Service
* @createDate 2025-06-26 09:20:41
*/
public interface PhoneuserService extends IService<Phoneuser> {
    boolean savePhoneUser(Phoneuser phoneuser);

    List<Phoneuser> FindAll();

    boolean dynamicUpdatePhoneUser(Phoneuser phoneuser);

    boolean deleteByUserId(Long userid);
}
