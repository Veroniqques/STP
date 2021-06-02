package com.example.demo.services;

import com.example.demo.employees.Employees;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * Интерфейс класса {@link Services}
 */
public interface ServicesRepo extends JpaRepository<Services, Long> {
}
