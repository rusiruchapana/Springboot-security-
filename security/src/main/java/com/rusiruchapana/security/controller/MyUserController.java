package com.rusiruchapana.security.controller;

import com.rusiruchapana.security.config.SecurityConfiguration;
import com.rusiruchapana.security.entity.MyUser;
import com.rusiruchapana.security.repository.MyUserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyUserController {

    private MyUserRepository myUserRepository;
    private SecurityConfiguration securityConfiguration;
    public MyUserController(MyUserRepository myUserRepository, SecurityConfiguration securityConfiguration) {
        this.myUserRepository = myUserRepository;
        this.securityConfiguration = securityConfiguration;
    }



    @PostMapping("/save")
    public MyUser register(@RequestBody MyUser myUser){
        myUser.setPassword(securityConfiguration.passwordEncoder().encode(myUser.getPassword()));
        myUserRepository.save(myUser);
        return myUser;
    }

}
//Finish