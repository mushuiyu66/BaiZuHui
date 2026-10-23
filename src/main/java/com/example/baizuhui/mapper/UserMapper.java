package com.example.baizuhui.mapper;
import com.example.baizuhui.domain.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import jakarta.transaction.Transactional;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author LENOVO
 * @description 针对表【user(用户)】的数据库操作Mapper
 * @createDate 2025-06-20 10:31:15
 * @Entity com.example.baizuhui.domain.User
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
    @Select("select * from user")
    List<User> FindAll();

    @Insert("INSERT INTO `user` (`unionId`,`miniOpenId`,`userName`,`userAvatar`) VALUES (#{unionId}, #{miniOpenId}, #{userName}, #{userAvatar});")
    @Transactional
    boolean saveUser(User user);

    @Update("<script>" +
            "UPDATE user " +
            "<set>" +
            "<if test='userName != null and userName != \"\"'>userName=#{userName},</if>" +
            "<if test='userAvatar != null and userAvatar != \"\"'>userAvatar=#{userAvatar},</if>" +
            "<if test='userRole != null'>userRole=#{userRole},</if>" +
            "<if test='updateTime != null'>updateTime=#{updateTime},</if>" +
            "<if test='isDelete != null'>isDelete=#{isDelete},</if>" +
            "<if test='false'>1 = 1</if>" + // 添加一个永远不成立的条件，避免 set 为空
            "</set>" +
            "WHERE id=#{id}" +
            "</script>")
    int dynamicUpdateUser(User user);

    @Delete("delete from user where id=#{id}")
    void deleteById(Long id);

    @Select("select * from user limit #{offset}, #{pageSize}")
    List<User> findByPage(Integer offset, Integer pageSize);

    @Select("select count(id) from user")
    Integer countUser();
}