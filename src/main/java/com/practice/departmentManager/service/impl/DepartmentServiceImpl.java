package com.practice.departmentManager.service.impl;

import com.practice.departmentManager.domain.department.Department;
import com.practice.departmentManager.repository.DepartmentRepository;
import com.practice.departmentManager.service.DepartmentService;
import com.practice.departmentManager.web.exception.ResourceNotFindException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    @Transactional(readOnly = true)
    public Department getById(Long id) {
        return departmentRepository.findById(id).orElseThrow(() ->
                new ResourceNotFindException("Department not found."));
    }

    @Override
    @Transactional(readOnly = true)
    public Department getByName(String name) {
        return departmentRepository.findByName(name).orElseThrow(() ->
                new ResourceNotFindException("Department not found."));
    }

    @Override
    @Transactional
    public Department update(Department department) {
        return departmentRepository.save(department);
    }

    @Override
    @Transactional
    public Department create(Department department) {
        if (departmentRepository.findByName(department.getName()).isPresent()) {
            throw new IllegalStateException("Department already exists.");
        }
        departmentRepository.save(department);
        return departmentRepository.save(department);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isEmployeeFromDepartment(Long departmentId, Long employeeId) {
        return departmentRepository.isEmployeeOwner(departmentId, employeeId);
    }

    @Override
    @Transactional(readOnly = true)
    public boolean isTaskFromDepartment(Long departmentId, Long taskId) {
        return departmentRepository.isTaskOwner(departmentId, taskId);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }
}
