package com.example.securitydemo.config;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.securitydemo.entity.User;
import com.example.securitydemo.mapper.UserMapper;
import jakarta.annotation.Resource;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsPasswordService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * ClassName: DBUserDetailsManager
 * Package: com.example.securitydemo.config
 * Description:
 *
 * @Author cyh
 * @Create 2024/3/14 11:10
 * @Version 1.0
 */
@Component
public class DBUserDetailsManager implements UserDetailsManager, UserDetailsPasswordService {
    @Resource
    private UserMapper userMapper;
    @Override
    public UserDetails updatePassword(UserDetails user, String newPassword) {
        return null;
    }

    @Override
    public void createUser(UserDetails userDetails) {
        User user = new User();
        user.setUsername(userDetails.getUsername());
        user.setPassword(userDetails.getPassword());
        user.setEnabled(true);
        userMapper.insert(user);


    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {

    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername,username);
        User user = userMapper.selectOne(queryWrapper);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        } else {
            Collection<GrantedAuthority> authorities = new ArrayList<>();

            return new org.springframework.security.core.userdetails.User(user.getUsername(),
                    user.getPassword(),
                    user.getEnabled(),
                    true //账户是否过期
                    , true,//账户凭证是否过期
                   true,//账户是否被锁定
                    authorities);//权限列表
        }


    }
}
