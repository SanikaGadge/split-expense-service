package com.sanika.splitexpenseservice.services;

import org.springframework.stereotype.Service;

import com.sanika.splitexpenseservice.dto.CreateExpenseRequest;
import com.sanika.splitexpenseservice.entity.Expense;
import com.sanika.splitexpenseservice.entity.Group;
import com.sanika.splitexpenseservice.entity.User;
import com.sanika.splitexpenseservice.repository.ExpenseRepository;
import com.sanika.splitexpenseservice.repository.GroupRepository;
import com.sanika.splitexpenseservice.repository.UserRepository;
import com.sanika.splitexpenseservice.strategy.SplitStrategy;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepo;
    private final UserRepository userRepo;
    private final GroupRepository groupRepo;
    private final SplitStrategyFactory strategyFactory;

    public void createExpense(CreateExpenseRequest request) {

        // 1. Fetch User & Group
        User paidBy = userRepo.findById(request.getPaidBy())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Group group = groupRepo.findById(request.getGroupId())
                .orElseThrow(() -> new RuntimeException("Group not found"));

        // 2. Create Expense
        Expense expense = new Expense();
        expense.setAmount(request.getAmount());
        expense.setDescription(request.getDescription());
        expense.setPaidBy(paidBy);
        expense.setGroup(group);

        expense = expenseRepo.save(expense);

        // 3. Create Splits
        SplitStrategy strategy = strategyFactory.getStrategy(request.getSplitType());

        strategy.applySplit(request, expense);
    }
}
