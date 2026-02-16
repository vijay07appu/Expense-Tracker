package com.springBootProject.expenseTracker.runner;

import com.springBootProject.expenseTracker.dto.ExpenseDTO;
import com.springBootProject.expenseTracker.mapper.ExpenseMapper;
import com.springBootProject.expenseTracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Scanner;

@Component
public class ExpenseRunner implements CommandLineRunner {
    @Autowired
    ExpenseService expenseService;
    Scanner sc = new Scanner(System.in);


    @Override
    public void run(String... args) throws Exception {

        while(true) {
            System.out.println("Welcome to Expense Tracker");
            System.out.println();

            boolean menuLoop = true;
            while (menuLoop) {
                System.out.println();
                System.out.println("Menu :");
                System.out.println("""
                        1.View All
                        2.Add Expense
                        3.Update Expense
                        4.Delete Expense
                        5.Exit""");
                System.out.println("Enter the Menu ");
                System.out.println();
                int menu = sc.nextInt();
                sc.nextLine();
                switch (menu) {
                    case 1: {

                        viewExpense();
                        break;
                    }
                    case 2: {
                        addExpense();
                        break;


                    }

                    case 3:{
                        updateExpense();
                        break;
                    }
                    case 4:{
                        deleteExpense();
                        break;
                    }
                    case 5: {
                        menuLoop = false;
                        break;
                    }
                }
            }
        }




    }

    public void viewExpense(){

        System.out.println("List of Expenses are ");
        try{ List<ExpenseDTO> expenses=expenseService.viewExpense();
            for(ExpenseDTO e:expenses)
            {
                System.out.println("id= "+e.getId()+" amount= "+ e.getAmount()+" description= "+e.getDescription()+" category= "+e.getCategory()+" date= "+e.getDate());
            }}
        catch(Exception e){
            e.printStackTrace();
        }



    }

    public void addExpense(){

        System.out.println("Enter the Expense Details to add the expense");
        System.out.println("Enter the amount");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter the description");
        String description = sc.nextLine();
        System.out.println("Enter the category");
        String category = sc.nextLine();
        ExpenseDTO expenseDTO = expenseService.addExpense(ExpenseDTO.builder()
                .amount(amount)
                .description(description)
                .category(category)
                .build());

        long id = expenseDTO.getId();
        System.out.println("Expense added successfully at id " + id);


    }

    public void updateExpense(){
        System.out.println("Enter the id to update");
        long id=sc.nextLong();
        sc.nextLine();
        System.out.println("Enter the amount");
        double amount = sc.nextDouble();
        sc.nextLine();
        System.out.println("Enter the description");
        String description = sc.nextLine();
        System.out.println("Enter the category");
        String category = sc.nextLine();
        expenseService.updateExpense(id,ExpenseDTO.builder()
                .amount(amount)
                .description(description)
                .category(category)
                .build());
        System.out.println("Expense updated successfully");

    }

    public void deleteExpense(){
        System.out.println("Enter the id to delete");
        long id=sc.nextLong();
        sc.nextLine();
        expenseService.deleteExpense(id);
        System.out.println("expense deleted successfully");
    }
}
