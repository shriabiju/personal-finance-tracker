package com.finance.tracker.repository;

import com.finance.tracker.model.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    // Get all expenses by user
    List<Expense> findByUserId(Long userId);

    // Get by category
    List<Expense> findByUserIdAndCategory(Long userId, String category);

    // Get by date range
    List<Expense> findByUserIdAndDateBetween(Long userId, LocalDate start, LocalDate end);

    // Total spending by user
    @Query("SELECT SUM(e.amount) FROM Expense e WHERE e.user.id = :userId")
    Double getTotalByUserId(Long userId);

    // Total by category
    @Query("SELECT SUM(e.amount) FROM Expense e WHERE e.user.id = :userId AND e.category = :category")
    Double getTotalByUserIdAndCategory(Long userId, String category);

}