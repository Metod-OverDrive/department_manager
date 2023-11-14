package com.practice.departmentManager.service.impl;

import com.practice.departmentManager.domain.employee.Employee;
import com.practice.departmentManager.repository.EmployeeRepository;
import com.practice.departmentManager.service.EmployeeService;
import com.practice.departmentManager.web.exception.ResourceNotFindException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    @Transactional(readOnly = true)
    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFindException("Employee not found."));
    }

    @Override
    @Transactional(readOnly = true)
    public Employee getByUsername(String username) {
        return employeeRepository.findByUsernameIgnoreCase(username).orElseThrow(() ->
                new ResourceNotFindException("Employee not found."));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAllByDepartmentId(Long id) {
        return employeeRepository.findAllByDepartmentId(id);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Employee> getAllEmployeeByTaskId(Long taskId) {
        return employeeRepository.findAllEmployeeByTaskId(taskId);
    }

    @Override
    @Transactional
    public Employee update(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    @Transactional
    public Employee create(Employee employee, Long departmentId) {
        if (employeeRepository.findByUsernameIgnoreCase(employee.getUsername()).isPresent()) {
            throw new IllegalStateException("Employee already exist.");
        }
        Employee updateEmployee = employeeRepository.save(employee);
        employeeRepository.assignEmployee(departmentId, updateEmployee.getId());
        return updateEmployee;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

}
