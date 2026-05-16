package com.finance.tracker.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BudgetDTO {

    private Long id;
    private Double monthlyLimit;
    private String month; // Format: "2024-01"
    private Long userId;
}