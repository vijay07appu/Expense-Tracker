package com.springBootProject.expenseTracker.service;

import com.springBootProject.expenseTracker.dto.ExpenseDTO;
import com.springBootProject.expenseTracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ExpenseServiceImpl implements ExpenseService{

    @Autowired
    ExpenseRepository expenseRepository;

    @Override
    public void addExpense(ExpenseDTO expenseDTO){
        List<ExpenseDTO> all=expenseRepository.findAll(expenseDTO);



    }
}
