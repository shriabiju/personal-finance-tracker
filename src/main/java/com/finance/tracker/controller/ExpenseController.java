package com.finance.tracker.controller;

import com.finance.tracker.dto.ExpenseDTO;
import com.finance.tracker.model.Expense;
import com.finance.tracker.service.ExpenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/expenses")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class ExpenseController {

    private final ExpenseService expenseService;

    // Add expense
    @PostMapping
    public ResponseEntity<Expense> addExpense(@RequestBody ExpenseDTO dto) {
        return ResponseEntity.ok(expenseService.addExpense(dto));
    }

    // Get all expenses by user
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Expense>> getExpenses(@PathVariable Long userId) {
        return ResponseEntity.ok(expenseService.getExpensesByUser(userId));
    }

    // Get by category
    @GetMapping("/user/{userId}/category/{category}")
    public ResponseEntity<List<Expense>> getByCategory(@PathVariable Long userId,
                                                        @PathVariable String category) {
        return ResponseEntity.ok(expenseService.getByCategory(userId, category));
    }

    // Get by date range
    @GetMapping("/user/{userId}/date")
    public ResponseEntity<List<Expense>> getByDateRange(@PathVariable Long userId,
                                                         @RequestParam String start,
                                                         @RequestParam String end) {
        return ResponseEntity.ok(expenseService.getByDateRange(
                userId, LocalDate.parse(start), LocalDate.parse(end)));
    }

    // Update expense
    @PutMapping("/{id}")
    public ResponseEntity<Expense> updateExpense(@PathVariable Long id,
                                                  @RequestBody ExpenseDTO dto) {
        return ResponseEntity.ok(expenseService.updateExpense(id, dto));
    }

    // Delete expense
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExpense(@PathVariable Long id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok("Expense deleted successfully!");
    }

    // Total spending
    @GetMapping("/user/{userId}/total")
    public ResponseEntity<Double> getTotalSpending(@PathVariable Long userId) {
        return ResponseEntity.ok(expenseService.getTotalSpending(userId));
    }
}