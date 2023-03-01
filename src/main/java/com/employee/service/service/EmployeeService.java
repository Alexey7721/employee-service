package com.employee.service.service;

import com.employee.service.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> getAll();

    Employee getById(int id);

    void save(Employee employee);

    void delete(int id);
}
