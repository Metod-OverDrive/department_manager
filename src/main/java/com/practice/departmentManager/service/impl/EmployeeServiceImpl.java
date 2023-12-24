package com.practice.departmentManager.service.impl;

import com.practice.departmentManager.domain.employee.Employee;
import com.practice.departmentManager.repository.EmployeeRepository;
import com.practice.departmentManager.service.EmployeeService;
import com.practice.departmentManager.web.exception.ResourceNotFindException;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional(readOnly = true)
 //   @Cacheable(value = "EmployeeService::getById", key = "#id")
    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() ->
                new ResourceNotFindException("Employee not found."));
    }

    @Override
    @Transactional(readOnly = true)
//    @Cacheable(value = "EmployeeService::getByUsername", key = "#username")
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
        employee.setPassword(passwordEncoder.encode(employee.getPassword()));
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
