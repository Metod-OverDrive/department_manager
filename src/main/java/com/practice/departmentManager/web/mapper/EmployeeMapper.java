package com.practice.departmentManager.web.mapper;

import com.practice.departmentManager.domain.employee.Employee;
import com.practice.departmentManager.web.dto.employee.EmployeeDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper {

    EmployeeDto toDto(Employee employee);

    Employee toEntity(EmployeeDto employeeDto);

    List<EmployeeDto> toDto(List<Employee> employees);
}
