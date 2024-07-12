package com.rusiruchapana.security.repository;

import com.rusiruchapana.security.entity.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MyUserRepository extends JpaRepository<MyUser,Long> {
}
