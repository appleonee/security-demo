package com.example.securitydemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * ClassName: IndexController
 * Package: com.example.securitydemo.controller
 * Description:
 *
 * @Author cyh
 * @Create 2024/3/14 8:39
 * @Version 1.0
 */
@Controller
public class IndexController {

    @GetMapping("/")
    public String index() {
        return "index";
    }
}
