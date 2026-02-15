package com.springBootProject.expenseTracker.service;

import com.springBootProject.expenseTracker.dto.ExpenseDTO;
import com.springBootProject.expenseTracker.entity.Expense;
import com.springBootProject.expenseTracker.mapper.ExpenseMapper;
import com.springBootProject.expenseTracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;


@Component
public class ExpenseServiceImpl implements ExpenseService{

    @Autowired
    ExpenseRepository expenseRepository;

    @Override
    public ExpenseDTO addExpense(ExpenseDTO expenseDTO){

        Expense expense= ExpenseMapper.dtoToEntity(expenseDTO);
        expense.setDate(LocalDate.now());
        return ExpenseMapper.entityToDto(expenseRepository.save(expense));


    }
}
