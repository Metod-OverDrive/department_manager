package com.practice.departmentManager.web.mapper;

import com.practice.departmentManager.domain.department.Department;
import com.practice.departmentManager.web.dto.department.DepartmentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper {

    DepartmentDto toDto(Department department);

    Department toEntity(DepartmentDto departmentDto);
}
