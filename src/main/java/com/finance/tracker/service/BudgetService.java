package com.finance.tracker.service;

import com.finance.tracker.dto.BudgetDTO;
import com.finance.tracker.model.Budget;
import com.finance.tracker.model.User;
import com.finance.tracker.repository.BudgetRepository;
import com.finance.tracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BudgetService {

    private final BudgetRepository budgetRepository;
    private final UserRepository userRepository;

    // Set or update budget
    public Budget setBudget(BudgetDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found!"));

        Optional<Budget> existing = budgetRepository
                .findByUserIdAndMonth(dto.getUserId(), dto.getMonth());

        if (existing.isPresent()) {
            Budget budget = existing.get();
            budget.setMonthlyLimit(dto.getMonthlyLimit());
            return budgetRepository.save(budget);
        }

        Budget budget = Budget.builder()
                .monthlyLimit(dto.getMonthlyLimit())
                .month(dto.getMonth())
                .user(user)
                .build();
        return budgetRepository.save(budget);
    }

    // Get budget by user and month
    public Budget getBudget(Long userId, String month) {
        return budgetRepository.findByUserIdAndMonth(userId, month)
                .orElseThrow(() -> new RuntimeException("Budget not found!"));
    }

    // Get remaining budget
    public Double getRemainingBudget(Long userId, String month, Double totalSpent) {
        Budget budget = getBudget(userId, month);
        return budget.getMonthlyLimit() - totalSpent;
    }
}