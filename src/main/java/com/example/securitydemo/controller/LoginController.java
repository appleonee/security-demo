package com.example.securitydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ClassName: LoginController
 * Package: com.example.securitydemo.controller
 * Description:
 *
 * @Author cyh
 * @Create 2024/3/14 16:11
 * @Version 1.0
 */
@Controller
public class LoginController {

    @GetMapping("login")
    public String login() {
        return "login";
    }

    ;
}
