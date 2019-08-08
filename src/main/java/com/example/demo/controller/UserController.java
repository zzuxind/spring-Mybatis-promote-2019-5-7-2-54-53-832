package com.example.demo.controller;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("")
public class UserController {
    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user")
    public List<User> findAll(@RequestParam int pageNum,@RequestParam int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<User> users=userMapper.queryList();
        return users;
    }

    @GetMapping("/user/{userId}")
    public User findById(@PathVariable long userId) {
        User user=userMapper.getUserById(userId);
        return user;
    }

    @PostMapping("/user")
    public void insertUser(@RequestBody User user) {
        userMapper.insertNewUser(user);
    }

    @PutMapping("/user/{userId}")
    public void updateUser(@PathVariable long userId,@RequestBody User user) {
        userMapper.updataUser(userId,user);
    }

    @DeleteMapping("/user/{userId}")
    public void deleteById(@PathVariable long userId) {
        userMapper.delete(userId);
    }
}
