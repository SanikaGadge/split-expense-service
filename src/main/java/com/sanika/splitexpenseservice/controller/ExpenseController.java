package com.sanika.splitexpenseservice.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sanika.splitexpenseservice.dto.CreateExpenseRequest;
import com.sanika.splitexpenseservice.entity.Expense;
import com.sanika.splitexpenseservice.repository.ExpenseRepository;
import com.sanika.splitexpenseservice.services.ExpenseService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/expenses")
public class ExpenseController {
    private final ExpenseRepository expenseRepository;
    private final ExpenseService expenseService;

    @PostMapping
    public String createExpense(@RequestBody CreateExpenseRequest request) {
        expenseService.createExpense(request);
        return "Expense created successfully";
    }

    @GetMapping
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

}
