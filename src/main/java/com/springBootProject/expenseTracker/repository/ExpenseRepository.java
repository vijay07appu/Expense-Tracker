package com.springBootProject.expenseTracker.repository;

import com.springBootProject.expenseTracker.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {
}
