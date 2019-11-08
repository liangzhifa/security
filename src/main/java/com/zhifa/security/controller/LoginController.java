package com.zhifa.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
    @RequestMapping("/login-success")
    public String success(){
        return "/login-success";
    }
    @RequestMapping("/r/r1")
    public String r1(){
        return "/r/r1";
    }
    @RequestMapping("/r/r2")
    public String r2(){
        return "/r/r2";
    }

    @RequestMapping("/r/r3")
    public String r3(){
        return "/r/r3";
    }
    @RequestMapping("/zhifa")
    public String zhifa(){
        return "zhifa";
    }
}
