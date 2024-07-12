package com.rusiruchapana.security.controller;

import com.rusiruchapana.security.entity.MyUser;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyUserController {

    @PostMapping("/save")
    public MyUser register(@RequestBody MyUser myUser){
        
    }

}
