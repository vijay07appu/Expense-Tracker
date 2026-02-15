package com.springBootProject.expenseTracker.mapper;

import com.springBootProject.expenseTracker.dto.ExpenseDTO;
import com.springBootProject.expenseTracker.entity.Expense;





public class ExpenseMapper {
    public static  ExpenseDTO entityToDto(Expense expense)
    {
        return ExpenseDTO.builder()
                .id(expense.getId())
                .amount(expense.getAmount())
                .description(expense.getDescription())
                .category(expense.getCategory())
                .date(expense.getDate())
                .build();

    }

    public static Expense dtoToEntity(ExpenseDTO expenseDTO)
    {
        return Expense.builder()
                .id(expenseDTO.getId())
                .amount(expenseDTO.getAmount())
                .description(expenseDTO.getDescription())
                .category(expenseDTO.getCategory())
                .date(expenseDTO.getDate())
                .build();
    }
}
