package com.restapistarter.expensetracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExpenseTrackerController {

    @Autowired
    private ExpenseTrackerRepository expenseTrackerRepository;

    @GetMapping("/getAllExp")
    private List<Expense> getAllExpenses() {
        return expenseTrackerRepository.findAll();
    }

    @GetMapping("/spentSum")
    private String getSpentTotal() {
        int sum = 0;
        List<Expense> expenseList = expenseTrackerRepository.findAll();

        for (Expense expense : expenseList) {
            sum += expense.getAmount();
        }
        return String.valueOf(sum);
    }

    @PutMapping("/addExpense")
    private Expense insertExpense(@RequestParam(name = "amount") int amount, @RequestParam(name = "category") String category) {
        return expenseTrackerRepository.save(new Expense(category, amount));
    }
}