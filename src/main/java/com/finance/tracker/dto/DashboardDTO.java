package com.finance.tracker.dto;

import lombok.*;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DashboardDTO {

    private Double totalMonthlySpending;
    private Double monthlyBudget;
    private Double remainingBudget;
    private Map<String, Double> categoryWiseSpending;
}