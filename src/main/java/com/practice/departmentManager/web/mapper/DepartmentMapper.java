package com.practice.departmentManager.web.mapper;

import com.practice.departmentManager.domain.department.Department;
import com.practice.departmentManager.web.dto.department.DepartmentDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper extends Mappable<Department, DepartmentDto> {

}
