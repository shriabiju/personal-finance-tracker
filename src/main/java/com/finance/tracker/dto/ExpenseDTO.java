package com.finance.tracker.dto;

import lombok.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ExpenseDTO {

    private Long id;
    private String title;
    private Double amount;
    private String category;
    private String description;
    private LocalDate date;
    private Long userId;
}
