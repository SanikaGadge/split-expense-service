package com.sanika.splitexpenseservice.strategy;

import org.springframework.stereotype.Service;

import com.sanika.splitexpenseservice.dto.CreateExpenseRequest;
import com.sanika.splitexpenseservice.entity.Expense;
import com.sanika.splitexpenseservice.entity.Split;
import com.sanika.splitexpenseservice.entity.User;
import com.sanika.splitexpenseservice.repository.SplitRepository;
import com.sanika.splitexpenseservice.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EqualSplitStrategy implements SplitStrategy {

    private final UserRepository userRepo;
    private final SplitRepository splitRepo;

    @Override
    public void applySplit(CreateExpenseRequest request, Expense expense) {

        int size = request.getParticipants().size();
        double splitAmount = request.getAmount() / size;

        for (Long userId : request.getParticipants()) {

            User user = userRepo.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

            Split split = new Split();
            split.setAmount(splitAmount);
            split.setUser(user);
            split.setExpense(expense);

            splitRepo.save(split);
        }
    }
}
