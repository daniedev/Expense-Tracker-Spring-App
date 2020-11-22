package com.restapistarter.expensetracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpenseTrackerController {

    @Autowired
    private ExpenseTrackerRepository expenseTrackerRepository;

    private static final String template = "Welcome, %s!";

    @GetMapping("/")
    public String greeting(@RequestParam(value = "name", defaultValue = "chief",required = false) String name) {
        return String.format(template,name).concat(" start tracking your expenses!!");
    }

    @GetMapping("/expenses")
    public List<Expense> greeting(@RequestParam(value = "name", required = false) Integer id) {
        if (id != null)
            return expenseTrackerRepository.findItem(id);
        return expenseTrackerRepository.findAll();
    }

    @PostMapping("/expense/add")
    public Expense addGreetingToDB(@RequestParam(value = "category") String category) {
        return expenseTrackerRepository.save(new Expense(category));
    }
}