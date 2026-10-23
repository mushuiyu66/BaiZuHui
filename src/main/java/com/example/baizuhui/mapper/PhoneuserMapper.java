package com.example.baizuhui.mapper;

import com.example.baizuhui.domain.AdminUsers;
import com.example.baizuhui.domain.Phoneuser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.baizuhui.domain.User;
import jakarta.transaction.Transactional;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
* @author LENOVO
* @description 针对表【phoneuser(手机登录用户表)】的数据库操作Mapper
* @createDate 2025-06-26 09:20:41
* @Entity generator.domain.Phoneuser
*/
public interface PhoneuserMapper extends BaseMapper<Phoneuser> {
    @Select("select * from phoneuser")
    List<Phoneuser> FindAll();

    @Insert("INSERT INTO `phoneuser` (`useraccount`,`password`) VALUES (#{useraccount}, #{password});")
    @Transactional
    boolean savePhoneUser(Phoneuser phoneuser);

    @Update("<script>" +
            "UPDATE phoneuser " +
            "<set>" +
            "<if test='useraccount != null and useraccount != \"\"'>useraccount=#{useraccount},</if>" +
            "<if test='password != null and password != \"\"'>password=#{password},</if>" +
            "<if test='false'>1 = 1</if>" + // 添加一个永远不成立的条件，避免 set 为空
            "</set>" +
            "WHERE userid=#{userid}" +
            "</script>")
    int dynamicUpdatePhoneUser(Phoneuser phoneuser);

    @Delete("delete from phoneuser where userid=#{userid}")
    void deleteByUserId(Long userid);
}




