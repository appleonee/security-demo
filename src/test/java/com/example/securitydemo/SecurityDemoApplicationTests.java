package com.example.securitydemo;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Assert;
import com.example.securitydemo.entity.User;
import com.example.securitydemo.mapper.UserMapper;
import com.example.securitydemo.service.UserService;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
class SecurityDemoApplicationTests {
    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    public void test01() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>();
        queryWrapper.eq(User::getId, 3);

        User one = userService.getOne(queryWrapper);
        System.out.println(one);
    }
    @Test
    public void test02(){
        // 工作因子，默认值是10，最小值是4，最大值是31，值越大运算速度越慢
        PasswordEncoder encoder = new BCryptPasswordEncoder(10);
        //明文："password"
        //密文：result，即使明文密码相同，每次生成的密文也不一致
        String result = encoder.encode("password");
        System.out.println(result);

        //密码校验
        Assert.isTrue(encoder.matches("password", result), "密码不一致");
    }
}
