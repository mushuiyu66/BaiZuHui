package com.example.baizuhui.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.baizuhui.domain.AdminUsers;
import com.example.baizuhui.service.AdminUsersService;
import com.example.baizuhui.mapper.AdminUsersMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author LENOVO
* @description 针对表【admin_users(后台系统用户表)】的数据库操作Service实现
* @createDate 2025-06-25 20:10:27
*/
@Service
public class AdminUsersServiceImpl extends ServiceImpl<AdminUsersMapper, AdminUsers>
    implements AdminUsersService{
    @Resource
    private AdminUsersMapper adminUsersMapper;

    @Override
    public boolean saveAdminUser(AdminUsers adminUsers) {
        boolean saveAdminUser = adminUsersMapper.saveAdminUser(adminUsers);
        return saveAdminUser;
    }

    @Override
    public List<AdminUsers> FindAll() {
        List<AdminUsers> FindAll=adminUsersMapper.FindAll();
        return FindAll;
    }

    @Override
    public boolean dynamicUpdateAdminUser(AdminUsers adminusers) {

        // 调用Mapper的动态更新方法
        int rows = adminUsersMapper.dynamicUpdateAdminUsers(adminusers);
        // 返回更新结果
        return rows > 0;
    }

    @Override
    public boolean deleteByAdminId(Long adminid) {
        if(adminid==null){
            return false;
        }
        adminUsersMapper.deleteByAdminId(adminid);
        return true;
    }


}




