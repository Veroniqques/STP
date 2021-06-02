package com.example.demo.entries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EntriesRepo extends JpaRepository<Entries, Long> {
    /**
     *
     * @param client_id
     * @return
     */
    @Query(value = "SELECT * FROM Entries WHERE clients_id = :clients_id",
            nativeQuery = true)
    List<Entries> findAllByClientId(@Param("clients_id") long client_id);

    /**
     *
     * @param employee_id
     * @return
     */
    @Query(value = "SELECT * FROM Entries WHERE employees_id = :employees_id",
            nativeQuery = true)
    List<Entries> findAllByEmployeeId(@Param("employees_id") long employee_id);

    /**
     *
     * @param service_id
     * @return
     */
    @Query(value = "SELECT * FROM Entries WHERE services_id = :services_id",
            nativeQuery = true)
    List<Entries> findAllByServiceId(@Param("services_id") long service_id);
}