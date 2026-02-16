package com.springBootProject.expenseTracker.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Valid
public class ExpenseDTO {

    private long id;
    @NotNull(message="Amount is required")
    @Positive(message="Amount should be positive")
    private double amount;

    @NotBlank(message="description is required")
    private String description;

    @NotBlank(message="category is required")
    private String category;
    private LocalDate date;
}
