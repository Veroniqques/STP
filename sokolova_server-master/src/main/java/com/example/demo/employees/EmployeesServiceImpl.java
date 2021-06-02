package com.example.demo.employees;

import com.example.demo.clients.Clients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * Сервис для {@link Employees\}
 */
@Service
public class EmployeesServiceImpl implements EmployeesService {

    @Autowired
    private EmployeesRepo employeesRepo;

    /**
     * Создание сотрудника
     * @param employee - информация о сотруднике
     * @return - созданный сотрудник
     */
    @Override
    public Employees create(Employees employee) {
        return employeesRepo.save(employee);
    }

    /**
     * Получает список всех сотрудников
     * @return - возвращает список сотрудников
     */
    @Override
    public List<Employees> readAll() {
        return employeesRepo.findAll();
    }

    /**
     * Получение сотрудника
     * @param id - идентификатор сотрудника
     * @return - возвращает одного сотрудника по id; null, если клиент не найден
     */
    @Override
    public Employees read(long id) {
        return employeesRepo.findById(id).orElse(null);
    }

    /**
     * Изменение сотрудника
     * @param employee - информация о сотруднике
     * @param id - идентификатор сотрудника
     * @return - boolean
     */
    @Override
    public boolean update(Employees employee, long id) {
        if (read(id) != null) {
            Employees updatedEmployee = new Employees();
            updatedEmployee.setId(id);
            updatedEmployee.setEducations(employee.getEducations());
            updatedEmployee.setEmail(employee.getEmail());
            updatedEmployee.setSalary(employee.getSalary());
            updatedEmployee.setExperience(employee.getExperience());
            updatedEmployee.setFirst_name(employee.getFirst_name());
            updatedEmployee.setLast_name(employee.getLast_name());
            updatedEmployee.setHire_date(employee.getHire_date());
            updatedEmployee.setPhone(employee.getPhone());
            updatedEmployee.setEmail(employee.getEmail());

            employeesRepo.save(updatedEmployee);
            return true;
        }

        return false;
    }

    /**
     * Удаление клиента
     * @param id - идентификатор сотрудника
     * @return - boolean
     */
    @Override
    public boolean delete(long id) {
        if (read(id) != null) {
            employeesRepo.deleteById(id);
            return true;
        }

        return false;
    }
}
