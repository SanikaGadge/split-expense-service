package com.sanika.splitexpenseservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sanika.splitexpenseservice.entity.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    
}
