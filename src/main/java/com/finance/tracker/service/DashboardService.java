package com.finance.tracker.service;

import com.finance.tracker.dto.DashboardDTO;
import com.finance.tracker.repository.ExpenseRepository;
import com.finance.tracker.repository.BudgetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final ExpenseRepository expenseRepository;
    private final BudgetRepository budgetRepository;
    private final BudgetService budgetService;

    public DashboardDTO getDashboard(Long userId, String month) {

        // Total monthly spending
        LocalDate start = LocalDate.parse(month + "-01");
        LocalDate end = start.withDayOfMonth(start.lengthOfMonth());
        Double totalSpending = expenseRepository
                .getTotalByUserId(userId);
        if (totalSpending == null) totalSpending = 0.0;

        // Monthly budget
        Double monthlyBudget = 0.0;
        Double remainingBudget = 0.0;
        try {
            monthlyBudget = budgetService.getBudget(userId, month).getMonthlyLimit();
            remainingBudget = monthlyBudget - totalSpending;
        } catch (Exception ignored) {}

        // Category wise spending
        Map<String, Double> categorySpending = new HashMap<>();
        for (String category : Arrays.asList(
                "Food", "Travel", "Shopping", "Bills", "Entertainment", "Health")) {
            Double amount = expenseRepository
                    .getTotalByUserIdAndCategory(userId, category);
            categorySpending.put(category, amount != null ? amount : 0.0);
        }

        return DashboardDTO.builder()
                .totalMonthlySpending(totalSpending)
                .monthlyBudget(monthlyBudget)
                .remainingBudget(remainingBudget)
                .categoryWiseSpending(categorySpending)
                .build();
    }
}