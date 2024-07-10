package com.rusiruchapana.security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
//@RequestMapping("/api/v1/application-controller")
public class ApplicationController {

    @GetMapping("/home")
    public String home(){
        return "HOME PAGE.";
    }

    @GetMapping("/user/home")
    public String user(){
        return "USER PAGE.";
    }

    @GetMapping("/admin/home")
    public String admin(){
        return "ADMIN PAGE.";
    }
}
