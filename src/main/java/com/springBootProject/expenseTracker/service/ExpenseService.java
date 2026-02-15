package com.springBootProject.expenseTracker.service;

import com.springBootProject.expenseTracker.dto.ExpenseDTO;
import com.springBootProject.expenseTracker.entity.Expense;
import org.springframework.stereotype.Service;

@Service
public interface ExpenseService {

    public ExpenseDTO addExpense(ExpenseDTO expenseDTO);
}
