package com.example.baizuhui.mapper;

import com.example.baizuhui.domain.AdminUsers;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.baizuhui.domain.Product;
import com.example.baizuhui.domain.User;
import jakarta.transaction.Transactional;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author LENOVO
* @description 针对表【admin_users(后台系统用户表)】的数据库操作Mapper
* @createDate 2025-06-25 20:10:27
* @Entity generator.domain.AdminUsers
*/
public interface AdminUsersMapper extends BaseMapper<AdminUsers> {
    @Select("select * from admin_users")
    List<AdminUsers> FindAll();

    @Insert("INSERT INTO `admin_users` (`username`,`password`) VALUES (#{username}, #{password});")
    @Transactional
    boolean saveAdminUser(AdminUsers adminUsers);

    @Update("<script>" +
            "UPDATE admin_users " +
            "<set>" +
            "<if test='username != null and username != \"\"'>username=#{username},</if>" +
            "<if test='password != null and password != \"\"'>password=#{password},</if>" +
            "<if test='false'>1 = 1</if>" + // 添加一个永远不成立的条件，避免 set 为空
            "</set>" +
            "WHERE adminid=#{adminid}" +
            "</script>")
    int dynamicUpdateAdminUsers(AdminUsers adminUsers);

    @Delete("delete from admin_users where adminid=#{adminid}")
    void deleteByAdminId(Long adminid);

}




