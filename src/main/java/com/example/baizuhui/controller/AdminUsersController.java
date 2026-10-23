package com.example.baizuhui.controller;

import com.example.baizuhui.domain.AdminUsers;

import com.example.baizuhui.service.AdminUsersService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminUsersController {


    /**
     * 查询所有数数据
     */
    @Resource
    private AdminUsersService adminUsersService;
    @GetMapping("/get-user")
    public List<AdminUsers> getUser(){
        return adminUsersService.FindAll();
    }


    /**
     * 添加
     */
    @PostMapping("/add-admin")
    public String addAdminUsers(@RequestBody AdminUsers adminUsers){
        boolean b = adminUsersService.saveAdminUser(adminUsers);
        if (!b) {
            return "失败";
        }
        return"success!";
    }

    /**
     * 动态更新用户
     */

    @PutMapping("/dynamicUpdate-admin")
    public String dynamicUpdate(@RequestBody AdminUsers adminUsers) {
        // 调用Service的动态更新方法
        boolean result = adminUsersService.dynamicUpdateAdminUser(adminUsers);
        // 返回结果
        if (result) {
            return "用户动态更新成功";
        } else {
            return "用户动态更新失败";
        }
    }


    /**
     * 删除
     */
    @DeleteMapping("/admin-{adminid}")
    public String deleteUser(@PathVariable("adminid")long adminid){
        adminUsersService.deleteByAdminId(adminid);
        return "success";
    }
}
