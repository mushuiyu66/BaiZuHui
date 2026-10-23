package com.example.baizuhui.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.baizuhui.domain.User;
import com.example.baizuhui.service.UserService;
import com.example.baizuhui.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

/**
* @author LENOVO
* @description 针对表【user(用户)】的数据库操作Service实现
* @createDate 2025-06-20 10:31:15
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{



    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> FindAll() {
        List<User> FindAll=userMapper.FindAll();
        return FindAll;
    }
    @Override
    public boolean saveUser(User user) {
        boolean saveUser = userMapper.saveUser(user);
        return saveUser;
    }

    @Override
    public boolean dynamicUpdateUser(User user) {
        // 调用Mapper的动态更新方法
        int rows = userMapper.dynamicUpdateUser(user);
        // 返回更新结果
        return rows > 0;
    }

    @Override
    public boolean deleteById(Long id) {
        if(id==null){
            return false;
        }
        userMapper.deleteById(id);
        return true;
    }

    @Override
    public List<User> findByPage(Integer offset, Integer pageSize) {
        return userMapper.findByPage(offset, pageSize);
    }

    @Override
    public Integer countUser() {
        return userMapper.countUser();
    }
}




