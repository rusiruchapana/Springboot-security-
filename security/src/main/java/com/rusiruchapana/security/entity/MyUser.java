package com.rusiruchapana.security.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "my_users")
public class MyUser {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String username;
    private String password;
}
