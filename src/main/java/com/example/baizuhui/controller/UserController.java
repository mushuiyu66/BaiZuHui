package com.example.baizuhui.controller;
import com.example.baizuhui.domain.User;
import com.example.baizuhui.service.UserService;
import com.example.baizuhui.vo.Page;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {


    /**
     * 查询所有数数据
     */
    @Resource
    private UserService userService;
    @GetMapping("/get-user")
    public List<User> getUser(){
        return userService.FindAll();
    }



    /**
     * 分页查询
     */
    @GetMapping("/findBy-page-user")
    public Page<User> findByPage(@RequestParam(defaultValue = "1") Integer pageNum,
                                 @RequestParam(defaultValue = "10") Integer pageSize) {
        Integer offset=(pageNum-1)*pageSize;
        List<User> userData = userService.findByPage(offset, pageSize);
        Page<User> page = new Page<>();
        page.setData(userData);

        Integer total= userService.countUser();
        page.setTotal(total);
        page.setPageNum(pageNum);
        page.setPageSize(pageSize);
        return page;
    }


    /**
     * 添加
     */
    @PostMapping("/add-user")
    public String addUser(@RequestBody User user){
        boolean b = userService.saveUser(user);
        if (!b) {
            return "失败";
        }
        return"success!";
    }


    /**
     * 动态更新用户
     */

    @PutMapping("/dynamicUpdate-user")
    public String dynamicUpdate(@RequestBody User user) {
        // 调用Service的动态更新方法
        boolean result = userService.dynamicUpdateUser(user);
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
    @DeleteMapping("/user-{id}")
    public String deleteUser(@PathVariable("id")long id){
        userService.deleteById(id);
        return "success";
    }


}
