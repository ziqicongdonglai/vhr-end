package com.example.vhr.controller;

import com.example.vhr.model.RespBean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ke_zhang
 * @create 2020/4/20 9:37
 * @description
 */
@RestController
public class LoginController {
    //测试请求
    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }
    @GetMapping("/login")
    public RespBean login() {
        return RespBean.error("尚未登录，请登录");
    }
}
