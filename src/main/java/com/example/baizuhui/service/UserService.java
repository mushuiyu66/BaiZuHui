package com.example.baizuhui.service;
import com.example.baizuhui.domain.User;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
* @author LENOVO
* @description 针对表【user(用户)】的数据库操作Service
* @createDate 2025-06-20 10:31:15
*/
public interface UserService extends IService<User> {

    boolean saveUser(User user);

    List<User> FindAll();

    boolean dynamicUpdateUser(User user);

    boolean deleteById(Long id);

    Integer countUser();

    List<User> findByPage(Integer offset, Integer pageSize);
}
