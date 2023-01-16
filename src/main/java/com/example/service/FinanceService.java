package com.example.service;

import com.example.dto.ExpenseDto;
import com.example.dto.MessageDto;
import com.example.dto.ResponseDto;
import com.example.entity.Expense;
import com.example.entity.User;
import com.example.repository.ExpenseRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FinanceService {
    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private UserRepository userRepository;

    public ResponseEntity<List<?>> getExpenses(Long id) {
        List<ExpenseDto> expenses = expenseRepository.findByUserIdOrderByDateDesc(id).stream()
                .map(this::createExpenseDto).toList();
        return ResponseEntity.ok(expenses);
    }

    private ExpenseDto createExpenseDto(Expense expense) {
        return new ExpenseDto(expense.getId(), expense.getDescription(), expense.getCategory(), expense.getValue(), expense.getDate());
    }

    public ResponseEntity<?> createExpense(ExpenseDto expenseDto) {
        System.out.println(expenseDto.getId());
        Expense expense = new Expense(expenseDto.getDescription(), expenseDto.getValue(), expenseDto.getDate(), expenseDto.getCategory(),
                userRepository.findById(expenseDto.getId()).get());
        expenseRepository.save(expense);
        return ResponseEntity.ok(new MessageDto("Expense was created", 200));
    }

    public ResponseEntity<?> deleteExpense(Long id) {
        expenseRepository.deleteById(id);
        return ResponseEntity.ok(new MessageDto("Expense was deleted", 200));
    }
}
