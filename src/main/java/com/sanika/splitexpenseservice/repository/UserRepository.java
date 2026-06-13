package com.sanika.splitexpenseservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanika.splitexpenseservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long>  {
    
}
