package com.practice.departmentManager.web.mapper;

import com.practice.departmentManager.domain.employee.Employee;
import com.practice.departmentManager.web.dto.employee.EmployeeDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface EmployeeMapper{

    @Mapping(target = "roles", ignore = true)
    Employee toEntity(EmployeeDto employeeDto);

    EmployeeDto toDto(Employee employee);

    List<EmployeeDto> toDto(List<Employee> employees);

}
