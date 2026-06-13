package com.sanika.splitexpenseservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanika.splitexpenseservice.entity.Split;

public interface SplitRepository extends JpaRepository<Split, Long> {
    
}
 