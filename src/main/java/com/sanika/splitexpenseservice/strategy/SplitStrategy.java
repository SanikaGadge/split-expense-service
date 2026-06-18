package com.sanika.splitexpenseservice.strategy;

import com.sanika.splitexpenseservice.dto.CreateExpenseRequest;
import com.sanika.splitexpenseservice.entity.Expense;

public interface SplitStrategy {
    void applySplit(CreateExpenseRequest request, Expense expense);
}
