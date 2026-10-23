package com.example.baizuhui.controller;

import com.example.baizuhui.domain.AdminUsers;
import com.example.baizuhui.domain.Phoneuser;
import com.example.baizuhui.mapper.PhoneuserMapper;
import com.example.baizuhui.service.PhoneuserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/phone")
public class PhoneUserController {
    @Resource
    private PhoneuserService phoneuserService;

    /**
     * 查询所有数数据
     */
    @GetMapping("/get-phone")
    public List<Phoneuser> getPhone(){
        return phoneuserService.FindAll();
    }

    /**
     * 添加
     */
    @PostMapping("/add-phone")
    public String addPhoneUser(@RequestBody Phoneuser phoneuser){
        boolean b = phoneuserService.savePhoneUser(phoneuser);
        if (!b) {
            return "失败";
        }
        return"success!";
    }


    /**
     * 动态更新用户
     */
    @PutMapping("/dynamicUpdate-phone")
    public String dynamicUpdate(@RequestBody Phoneuser phoneuser) {
        // 调用Service的动态更新方法
        boolean result = phoneuserService.dynamicUpdatePhoneUser(phoneuser);
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
    @DeleteMapping("/admin-{userid}")
    public String deleteUser(@PathVariable("userid")long userid){
        phoneuserService.deleteByUserId(userid);
        return "success";
    }
}
