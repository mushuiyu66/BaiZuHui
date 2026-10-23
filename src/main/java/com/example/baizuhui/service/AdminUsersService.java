package com.example.baizuhui.service;

import com.example.baizuhui.domain.AdminUsers;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.baizuhui.domain.User;

import java.util.List;

/**
* @author LENOVO
* @description 针对表【admin_users(后台系统用户表)】的数据库操作Service
* @createDate 2025-06-25 20:10:27
*/
public interface AdminUsersService extends IService<AdminUsers> {

    boolean saveAdminUser(AdminUsers adminUsers);
    List<AdminUsers> FindAll();

    boolean dynamicUpdateAdminUser(AdminUsers adminusers);

    boolean deleteByAdminId(Long adminid);
}
