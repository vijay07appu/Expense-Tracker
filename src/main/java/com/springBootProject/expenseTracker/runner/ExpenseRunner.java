package com.springBootProject.expenseTracker.runner;

import com.springBootProject.expenseTracker.dto.ExpenseDTO;
import com.springBootProject.expenseTracker.mapper.ExpenseMapper;
import com.springBootProject.expenseTracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ExpenseRunner implements CommandLineRunner {
    @Autowired
    ExpenseService expenseService;


    @Override
    public void run(String... args) throws Exception {
        System.out.println("Welcome to Expense Tracker");
        System.out.println();
        Scanner sc=new Scanner(System.in);
        System.out.println("Menu :");
        System.out.println("""
                1.View All
                2.Add Expense
                3.Update Expense
                4.Delete Expense""");
        System.out.println("Enter the Menu ");
        int menu=sc.nextInt();
        sc.nextLine();
        switch (menu){
            case 1:{}
            case 2:{
                System.out.println("Enter the Expense Details to add the expense");
                System.out.println("Enter the amount");
                double amount=sc.nextDouble();
                sc.nextLine();
                System.out.println("Enter the description");
                String description=sc.nextLine();
                System.out.println("Enter the category");
                String category=sc.nextLine();
                ExpenseDTO expenseDTO=expenseService.addExpense(ExpenseDTO.builder()
                        .amount(amount)
                        .description(description)
                        .category(category)
                        .build());

                 long id=expenseDTO.getId();
                 System.out.println("Expense added successfully at id "+id);


            }
        }




    }
}
