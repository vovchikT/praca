package com.example.controller;

import com.example.dto.ExpenseDto;
import com.example.entity.Expense;
import com.example.service.FinanceService;
import com.example.service.LoginService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FinanceController {
    @Autowired
    private FinanceService financeService;

    @CrossOrigin
    @GetMapping("/finances/{id}")
    public @ResponseBody
    ResponseEntity<List<?>> getExpenses(@PathVariable Long id) {
        return financeService.getExpenses(id);
    }

    @CrossOrigin
    @GetMapping("/finances/delete/{id}")
    public @ResponseBody
    ResponseEntity<?> deleteExpense(@PathVariable Long id) {
        return financeService.deleteExpense(id);
    }

    @CrossOrigin
    @PostMapping("finance/create")
    public ResponseEntity<?> createExpense(@Valid @RequestBody ExpenseDto expenseDto) {
        return financeService.createExpense(expenseDto);
    }
}
