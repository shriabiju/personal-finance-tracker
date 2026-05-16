package com.finance.tracker.controller;

import com.finance.tracker.dto.BudgetDTO;
import com.finance.tracker.model.Budget;
import com.finance.tracker.service.BudgetService;
import com.finance.tracker.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/budgets")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class BudgetController {

    private final BudgetService budgetService;
    private final ExpenseService expenseService;

    // Set or update budget
    @PostMapping
    public ResponseEntity<Budget> setBudget(@RequestBody BudgetDTO dto) {
        return ResponseEntity.ok(budgetService.setBudget(dto));
    }

    // Get budget by user and month
    @GetMapping("/user/{userId}/month/{month}")
    public ResponseEntity<Budget> getBudget(@PathVariable Long userId,
                                             @PathVariable String month) {
        return ResponseEntity.ok(budgetService.getBudget(userId, month));
    }

    // Get remaining budget
    @GetMapping("/user/{userId}/month/{month}/remaining")
    public ResponseEntity<Double> getRemaining(@PathVariable Long userId,
                                                @PathVariable String month) {
        Double totalSpent = expenseService.getTotalSpending(userId);
        return ResponseEntity.ok(budgetService.getRemainingBudget(userId, month, totalSpent));
    }
}
