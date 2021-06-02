package com.example.demo.shares;

import com.example.demo.employees.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс класса {@link Shares}
 */
public interface SharesRepo extends JpaRepository<Shares, Long> {
}
