package com.example.repository;

import com.example.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    //@Query(value = "select * from expenses e where e.user_id = :id", nativeQuery = true)
    List<Expense> findByUserIdOrderByDateDesc(Long userId);

  void deleteById(Long id);
}
