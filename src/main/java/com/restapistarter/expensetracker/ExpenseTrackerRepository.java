package com.restapistarter.expensetracker;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseTrackerRepository extends JpaRepository<Expense, Integer> {

    @Query(value = "select * from expense where id = ?1", nativeQuery = true)
    List<Expense> findItem(Integer id);

    @Query(value = "select * from expense", nativeQuery = true)
    List<Expense> getAllExpenses();
}
