package com.finance.tracker.repository;

import com.finance.tracker.model.Budget;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;

@Repository
public interface BudgetRepository extends JpaRepository<Budget, Long> {

    // Get budget by user and month
    Optional<Budget> findByUserIdAndMonth(Long userId, String month);

    // Get all budgets by user
    List<Budget> findByUserId(Long userId);
}