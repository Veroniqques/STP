package com.example.demo.employees;

import com.example.demo.clients.Clients;
import com.example.demo.entries.EntriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Контроллер для {@link Employees}
 */
@RestController
public class EmployeesController {

    private final EmployeesService employeesService;
    private final EntriesService entriesService;

    /**
     * Инициализация контроллера для сущности сотрудника
     * @param employeesService - employees Service
     * @param entriesService - entries Service
     */
    @Autowired
    public EmployeesController(EmployeesService employeesService, EntriesService entriesService) {
        this.employeesService = employeesService;
        this.entriesService = entriesService;
    }

    /**
     * Получение списка всех сотрудников
     * @return - Возвращает сотрудников, если те содержат элементы; Ошибку,если не найден
     */
    @GetMapping(value = "/employees")
    public ResponseEntity<List<Employees>> readEmployees() {
        final List<Employees> employees = employeesService.readAll();

        return employees != null && !employees.isEmpty()
                ? new ResponseEntity<>(employees, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Изменение сотрудника
     * @param employee - новая информация о сотруднике
     * @param id - идентификатор сотрудника
     * @return - OK - если существует, NOT_FOUND если не существует
     */
    @PutMapping(value = "/employees/{id}")
    public ResponseEntity<?> updateEmployee(@RequestBody Employees employee, @PathVariable(name = "id") int id) {
        if (employeesService.update(employee, id)) {
            return new ResponseEntity<>(HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     * Удаление сотрудника по id
     * @param id - идентификатор сотрудника
     * @return - OK - если существует, NOT_FOUND если не существует
     */
    @DeleteMapping(value = "/employees/{id}")
    public ResponseEntity<?> deleteEmployee(@PathVariable(name = "id") int id) {
        if (employeesService.read(id) != null) {
            entriesService.deleteByServiceId(id);
            employeesService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    /**
     *Добавление сотрудника
     * @param employee - информация о сотрдунике
     * @return -  Добавленный сотрудник
     */
    @PostMapping("/employees")
    public Employees createNewEntry(@RequestBody Employees employee) {
        return employeesService.create(employee);
    }

}
