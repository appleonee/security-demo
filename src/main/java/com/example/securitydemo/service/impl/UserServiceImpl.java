package com.example.securitydemo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.securitydemo.config.DBUserDetailsManager;
import com.example.securitydemo.entity.User;
import com.example.securitydemo.mapper.UserMapper;
import com.example.securitydemo.service.UserService;
import jakarta.annotation.Resource;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 * ClassName: UserServiceImpl
 * Package: com.example.securitydemo.service.impl
 * Description:
 *
 * @Author cyh
 * @Create 2024/3/14 10:27
 * @Version 1.0
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService  {

    @Resource
    private DBUserDetailsManager dbUserDetailsManager;
    @Override
    public void saveUserDetails(User user) {

        UserDetails userDetails = org.springframework.security.core.userdetails.User.withDefaultPasswordEncoder()
                .username(user.getUsername())
                .password(user.getPassword()).build();
        dbUserDetailsManager.createUser(userDetails);
    }
}
