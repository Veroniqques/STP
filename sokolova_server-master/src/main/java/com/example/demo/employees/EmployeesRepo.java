package com.example.demo.employees;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс класса {@link Employees}
 */
public interface EmployeesRepo extends JpaRepository<Employees, Long> {
}
