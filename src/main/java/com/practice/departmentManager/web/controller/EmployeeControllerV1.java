package com.practice.departmentManager.web.controller;

import com.practice.departmentManager.domain.employee.Employee;
import com.practice.departmentManager.service.EmployeeService;
import com.practice.departmentManager.web.dto.employee.EmployeeDto;
import com.practice.departmentManager.web.dto.validation.OnCreate;
import com.practice.departmentManager.web.dto.validation.OnUpdate;
import com.practice.departmentManager.web.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/employees")
@RequiredArgsConstructor
@Validated
public class EmployeeControllerV1 {

    private final EmployeeService employeeService;

    private final EmployeeMapper employeeMapper;

    @PutMapping
    public EmployeeDto update(@Validated({OnUpdate.class})
                          @RequestBody EmployeeDto dto) {
        Employee employee = employeeMapper.toEntity(dto);
        Employee updatedEmployee = employeeService.update(employee);
        return employeeMapper.toDto(updatedEmployee);
    }

    @GetMapping("/{id}")
    public EmployeeDto getById(@PathVariable Long id) {
        Employee employee = employeeService.getById(id);
        return employeeMapper.toDto(employee);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        employeeService.delete(id);
    }
}
