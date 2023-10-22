package com.practice.departmentManager.repository;

import com.practice.departmentManager.domain.department.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findByName(String name);

    @Query(value = """
        SELECT exists(
                SELECT  1
                FROM departments_tasks
                WHERE department_id = :departmentId
                AND task_id = :taskId)
        """, nativeQuery = true)
    boolean isTaskOwner(@Param("departmentId") Long departmentId, @Param("taskId") Long taskId);

    @Query(value = """
        SELECT exists(
            SELECT 1
            FROM departments_employees
            WHERE department_id = :departmentId
            AND employee_id = :employeeId)
        """, nativeQuery = true)
    boolean isEmployeeOwner(@Param("departmentId") Long departmentId, @Param("EmployeeId") Long employeeId);
}
