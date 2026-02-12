package com.springBootProject.expenseTracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExpenseDTO {

    private long id;
    private double amount;
    private String description;
    private String category;
    private LocalDateTime date;
}
