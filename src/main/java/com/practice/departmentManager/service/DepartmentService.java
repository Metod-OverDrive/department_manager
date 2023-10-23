package com.practice.departmentManager.service;


import com.practice.departmentManager.domain.department.Department;

public interface DepartmentService {

    Department getById(Long id);
    Department getByName(String name);
    Department update(Department department);
    Department create(Department department);
    boolean isEmployeeFromDepartment(Long departmentId, Long employeeId);
    boolean isTaskFromDepartment(Long departmentId, Long taskId);
    void delete(Long id);
}