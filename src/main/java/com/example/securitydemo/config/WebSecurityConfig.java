package com.example.securitydemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

/**
 * ClassName: WebSecurityConfig
 * Package: com.example.securitydemo.config
 * Description:
 *
 * @Author cyh
 * @Create 2024/3/14 9:47
 * @Version 1.0
 */
@Configuration
//@EnableWebSecurity//Spring项目总需要添加此注解，SpringBoot项目中不需要
public class WebSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        //authorizeRequests()：开启授权保护
        //anyRequest()：对所有请求开启授权保护
        //authenticated()：已认证请求会自动被授权
        http
                .authorizeRequests(authorize -> authorize.anyRequest().authenticated())
                .formLogin(form -> {
                    form
                            .loginPage("/login").permitAll() //登录页面无需授权即可访问
                            .usernameParameter("username") //自定义表单用户名参数，默认是username
                            .passwordParameter("password") //自定义表单密码参数，默认是password
                            .failureUrl("/login?error") //登录失败的返回地址
                    ;
                })//表单授权方式
                .httpBasic(withDefaults());//基本授权方式
        http.csrf((csrf) -> {
            csrf.disable();
        });


        return http.build();
        //关闭csrf攻击防御

    }
   /* @Bean
    public UserDetailsService userDetailsService() {
        //创建基于内存的用户信息管理器
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        //使用manager管理UserDetails对象
        manager.createUser( //此行设置断点可以查看创建的user对象
                //创建UserDetails对象 管理用户名 密码 角色 权限等
                User
                        .withDefaultPasswordEncoder()
                        .username("huan") //自定义用户名
                        .password("password") //自定义密码
                        .roles("USER") //自定义角色
                        .build()
        );
        return manager;
    }*/

   /* @Bean
    public UserDetailsService userDetailsService() {
        //创建基于数据库的用户信息管理器
        DBUserDetailsManager manager = new DBUserDetailsManager();

        return manager;
    }*/
}
