package com.example.demo.employees;

import com.example.demo.clients.Clients;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeesServiceImplTest {

    @Autowired
    private EmployeesServiceImpl employeesService;
    @MockBean
    private EmployeesRepo employeesRepo;

    @Test
    public void create() {
        Employees employees = new Employees();
        Employees expected = new Employees();
        expected.setId(1L);
        Mockito.when(employeesRepo.save(employees)).thenReturn(expected);
        Employees actual = employeesService.create(employees);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void readAll() {
        List<Employees> expected = new ArrayList<>();
        Mockito.when(employeesRepo.findAll()).thenReturn(expected);
        List<Employees> employees = employeesService.readAll();
        Assertions.assertEquals(expected, employees);
    }

    @Test
    public void read() {
        Employees employees = new Employees();
        employees.setId(1L);
        Optional<Employees> expected = Optional.of(employees);
        Mockito.when(employeesRepo.findById(1L)).thenReturn(expected);
        Assertions.assertEquals(employees, employeesService.read(1L));
    }

    @Test
    public void update() {
        Employees employees = new Employees();
        employees.setId(1L);
        Optional<Employees> expected = Optional.of(employees);
        Mockito.when(employeesRepo.findById(1L)).thenReturn(expected);
        Assertions.assertTrue(employeesService.update(employees, 1L));
    }

    @Test
    public void delete() {
        Employees employees = new Employees();
        employees.setId(1L);
        Optional<Employees> expected = Optional.of(employees);
        Mockito.when(employeesRepo.findById(1L)).thenReturn(expected);
        Assertions.assertTrue(employeesService.delete(1L));
    }
}