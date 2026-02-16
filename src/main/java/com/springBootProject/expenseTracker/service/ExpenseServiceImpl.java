package com.springBootProject.expenseTracker.service;

import com.springBootProject.expenseTracker.dto.ExpenseDTO;
import com.springBootProject.expenseTracker.entity.Expense;
import com.springBootProject.expenseTracker.mapper.ExpenseMapper;
import com.springBootProject.expenseTracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
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

    @Override
    public List<ExpenseDTO> viewExpense() throws IOException{
        FileWriter file=new FileWriter("expense.csv");
        PrintWriter writer=new PrintWriter(file);
        writer.println("id,Amount,Description,Category,date");

        List<Expense> all=expenseRepository.findAll();
        List<ExpenseDTO> allDto=new ArrayList<>();
        for(Expense e:all)
        {
            allDto.add(ExpenseMapper.entityToDto(e));
            writer.println(
                    e.getId() + "," +
                            e.getDescription() + "," +
                            e.getAmount() + "," +
                            e.getCategory()+"," +
                            e.getDate()
            );

        }
        writer.close();
        return allDto;
    }

    @Override
    public ExpenseDTO updateExpense(long id,ExpenseDTO expenseDTO){
        Expense expense=expenseRepository.findById(id);
        if(expense==null)
        {
            System.out.println("Id does not exist");
        }
        expense.setAmount(expenseDTO.getAmount());
        expense.setCategory(expenseDTO.getCategory());
        expense.setDescription(expenseDTO.getDescription());
        return ExpenseMapper.entityToDto(expenseRepository.save(expense));





    }

    @Override
    public void deleteExpense(long id){
        Expense expense=expenseRepository.findById(id);
        if(expense==null)
        {
            System.out.println("Id does not exist");
        }
        expenseRepository.deleteById(id);
    }
}
