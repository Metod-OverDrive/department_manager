package com.practice.departmentManager.service;

import com.practice.departmentManager.domain.employee.Employee;

import java.util.List;

public interface EmployeeService {

    Employee getById(Long id);
    Employee getByUsername(String username);
    List<Employee> getAllByDepartmentId(Long id);
    List<Employee> getAllEmployeeByTaskId(Long taskId);
    Employee update(Employee employee);
    Employee create(Employee employee, Long departmentId);
    void delete(Long id);
}
