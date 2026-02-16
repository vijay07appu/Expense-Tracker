package com.springBootProject.expenseTracker.service;

import com.springBootProject.expenseTracker.dto.ExpenseDTO;
import com.springBootProject.expenseTracker.entity.Expense;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public interface ExpenseService {

    public ExpenseDTO addExpense(ExpenseDTO expenseDTO);
    public List<ExpenseDTO> viewExpense() throws IOException;
    public ExpenseDTO updateExpense(long id,ExpenseDTO expenseDTO);
    public void deleteExpense(long id);
}
