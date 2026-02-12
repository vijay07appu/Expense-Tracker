package com.springBootProject.expenseTracker.service;

import com.springBootProject.expenseTracker.dto.ExpenseDTO;
import org.springframework.stereotype.Service;

@Service
public interface ExpenseService {

    public void addExpense(ExpenseDTO expenseDTO);
}
