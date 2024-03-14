package com.example.securitydemo.controller;

import com.example.securitydemo.entity.User;
import com.example.securitydemo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ClassName: UserController
 * Package: com.example.securitydemo.controller
 * Description:
 *
 * @Author cyh
 * @Create 2024/3/14 10:30
 * @Version 1.0
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Resource
    public UserService userService;

    @GetMapping("/list")
    public List<User> getList(){
        return userService.list();
    }
    @PostMapping("/add")
    public void add(@RequestBody User user){
        userService.saveUserDetails(user);
    }
}
