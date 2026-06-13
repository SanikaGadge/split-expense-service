package com.sanika.splitexpenseservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanika.splitexpenseservice.entity.Group;

public interface GroupRepository extends JpaRepository<Group, Long> {
    
}
