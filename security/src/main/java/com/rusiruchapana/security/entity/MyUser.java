package com.rusiruchapana.security.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "my_users")
public class MyUser {

    
    private Long id;
    private String username;
    private String password;
}
