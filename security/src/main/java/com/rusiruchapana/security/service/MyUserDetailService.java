package com.rusiruchapana.security.service;

import com.rusiruchapana.security.entity.MyUser;
import com.rusiruchapana.security.repository.MyUserRepository;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    private MyUserRepository myUserRepository;
    public MyUserDetailService(MyUserRepository myUserRepository) {
        this.myUserRepository = myUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<MyUser> myUser = myUserRepository.findByUsername(username);

        MyUser myUser1 = myUser.get();
        if(myUser.isPresent()){
            return User.builder()
                    .username(myUser1.getUsername())
                    .password(myUser1.getPassword())
                    .roles(getRoles(myUser1))
                    .build();

        }else{
            throw new UsernameNotFoundException(username);
        }


    }

    private String[] getRoles(MyUser myUser1) {
        if(myUser1.getRole()==null){
            return new String[]{"USER"};
        }
        return myUser1.getRole().split(",");
    }
}
