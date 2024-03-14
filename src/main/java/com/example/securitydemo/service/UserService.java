package com.example.securitydemo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.securitydemo.entity.User;

/**
 * ClassName: UserService
 * Package: com.example.securitydemo.service
 * Description:
 *
 * @Author cyh
 * @Create 2024/3/14 10:27
 * @Version 1.0
 */
public interface UserService extends IService<User> {
    void saveUserDetails(User user);
}
