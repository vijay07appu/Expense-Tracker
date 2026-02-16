package com.springBootProject.expenseTracker.service;

import com.springBootProject.expenseTracker.dto.ExpenseDTO;
import com.springBootProject.expenseTracker.entity.Expense;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ExpenseService {

    public ExpenseDTO addExpense(ExpenseDTO expenseDTO);
    public List<ExpenseDTO> viewExpense();
    public ExpenseDTO updateExpense(long id,ExpenseDTO expenseDTO);
    public void deleteExpense(long id);
}
