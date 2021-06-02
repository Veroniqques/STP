package com.example.demo.clients;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс для класса {@link Clients}
 */
public interface ClientsRepo extends JpaRepository<Clients, Long> {


}
