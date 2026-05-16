package com.finance.tracker.service;

import com.finance.tracker.dto.ExpenseDTO;
import com.finance.tracker.model.Expense;
import com.finance.tracker.model.User;
import com.finance.tracker.repository.ExpenseRepository;
import com.finance.tracker.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;

    // Add expense
    public Expense addExpense(ExpenseDTO dto) {
        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found!"));
        Expense expense = Expense.builder()
                .title(dto.getTitle())
                .amount(dto.getAmount())
                .category(dto.getCategory())
                .description(dto.getDescription())
                .date(dto.getDate())
                .user(user)
                .build();
        return expenseRepository.save(expense);
    }

    // Get all expenses by user
    public List<Expense> getExpensesByUser(Long userId) {
        return expenseRepository.findByUserId(userId);
    }

    // Get expenses by category
    public List<Expense> getByCategory(Long userId, String category) {
        return expenseRepository.findByUserIdAndCategory(userId, category);
    }

    // Get expenses by date range
    public List<Expense> getByDateRange(Long userId, LocalDate start, LocalDate end) {
        return expenseRepository.findByUserIdAndDateBetween(userId, start, end);
    }

    // Update expense
    public Expense updateExpense(Long id, ExpenseDTO dto) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found!"));
        expense.setTitle(dto.getTitle());
        expense.setAmount(dto.getAmount());
        expense.setCategory(dto.getCategory());
        expense.setDescription(dto.getDescription());
        expense.setDate(dto.getDate());
        return expenseRepository.save(expense);
    }

    // Delete expense
    public void deleteExpense(Long id) {
        expenseRepository.deleteById(id);
    }

    // Total spending by user
    public Double getTotalSpending(Long userId) {
        Double total = expenseRepository.getTotalByUserId(userId);
        return total != null ? total : 0.0;
    }

    // Category wise spending
    public Double getCategorySpending(Long userId, String category) {
        Double total = expenseRepository.getTotalByUserIdAndCategory(userId, category);
        return total != null ? total : 0.0;
    }
}