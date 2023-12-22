package com.bigc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class LoginController {

    @GetMapping
    public String getRegisterPage() {
        return "/site/register";
    }
}
