package com.practice.departmentManager.repository;

import com.practice.departmentManager.domain.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    Optional<Employee> findByUsernameIgnoreCase(String username);

    @Modifying
    @Query(value = """
        INSERT INTO departments_employees (department_id, employee_id)
        VALUES (:departmentId, :employeeId)
        """, nativeQuery = true)
    void assignEmployee(@Param("departmentId") Long departmentId, @Param("employeeId") Long employeeId);

    @Query(value = """
        SELECT * FROM employees e
        JOIN departments_employees de on e.id = de.employee_id
        where de.department_id = :departmentId
        """, nativeQuery = true)
    List<Employee> findAllByDepartmentId(@Param("departmentId") Long departmentId);
}
