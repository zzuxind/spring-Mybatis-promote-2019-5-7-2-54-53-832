package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    // 1. 实现查询所有用户
    @Select("select * from user")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name")
    })
    public List<User> queryList();

    // 2. 根据用户id查询用户
    @Select("select * from user where id=#{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "name",column = "name")
    })
    public User getUserById(long id);

    // 3. 添加新用户
    @Insert( "insert into user(id,name) values (#{id},#{name})")
    public int insertNewUser(User user);

    // 4. 根据用户id删除用户
    @Delete("delete from user where id=#{id}")
    public int delete(long id);

    // 5. 根据用户id更新用户
    @Update("update user set id=#{user.id},name=#{user.name} where id=#{id}")
    public int updataUser(@Param("id") long id, User user);

}