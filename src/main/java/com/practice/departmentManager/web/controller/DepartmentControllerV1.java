package com.practice.departmentManager.web.controller;

import com.practice.departmentManager.domain.department.Department;
import com.practice.departmentManager.domain.employee.Employee;
import com.practice.departmentManager.domain.task.Task;
import com.practice.departmentManager.service.DepartmentService;
import com.practice.departmentManager.service.EmployeeService;
import com.practice.departmentManager.service.TaskService;
import com.practice.departmentManager.web.dto.department.DepartmentDto;
import com.practice.departmentManager.web.dto.employee.EmployeeDto;
import com.practice.departmentManager.web.dto.task.TaskDto;
import com.practice.departmentManager.web.dto.validation.OnUpdate;
import com.practice.departmentManager.web.mapper.DepartmentMapper;
import com.practice.departmentManager.web.mapper.EmployeeMapper;
import com.practice.departmentManager.web.mapper.TaskMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/departments")
@RequiredArgsConstructor
@Validated
public class DepartmentControllerV1 {

    private final DepartmentService departmentService;
    private final EmployeeService employeeService;
    private final TaskService taskService;

    private final DepartmentMapper departmentMapper;
    private final EmployeeMapper employeeMapper;
    private final TaskMapper taskMapper;

    @GetMapping("/{id}")
    public DepartmentDto getById(@PathVariable Long id) {
        Department department = departmentService.getById(id);
        return departmentMapper.toDto(department);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable final Long id) {
        departmentService.delete(id);
    }

    @PutMapping
    public DepartmentDto update(@Validated(OnUpdate.class)
                                    @RequestBody DepartmentDto dto) {
        Department department = departmentMapper.toEntity(dto);
        Department updatedDepartment = departmentService.update(department);
        return departmentMapper.toDto(updatedDepartment);
    }

    @GetMapping("/{id}/tasks")
    public List<TaskDto> getTasksByDepartmentId(@PathVariable Long id) {
        List<Task> tasks = taskService.getAllByDepartmentId(id);
        return taskMapper.toDto(tasks);
    }

    @GetMapping("/{id}/employees")
    public List<EmployeeDto> getEmployeesByDepartmentId(@PathVariable Long id) {
        List<Employee> employees = employeeService.getAllByDepartmentId(id);
        return employeeMapper.toDto(employees);
    }

}
