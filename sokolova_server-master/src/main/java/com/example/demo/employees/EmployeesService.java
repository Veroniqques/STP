package com.example.demo.employees;

import java.util.List;


public interface EmployeesService {

    Employees create(Employees employee);

    List<Employees> readAll();

    Employees read(long id);

    boolean update(Employees employee, long id);

    boolean delete(long id);

}
