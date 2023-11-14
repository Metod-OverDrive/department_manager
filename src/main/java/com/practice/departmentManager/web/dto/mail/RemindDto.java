package com.practice.departmentManager.web.dto.mail;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.practice.departmentManager.domain.employee.Employee;
import lombok.Getter;
import lombok.Setter;


import java.util.Date;
import java.util.List;

@Getter
@Setter
public class RemindDto {

    private String taskTitle;
    private String taskDescription;
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private Date expirationDate;
    private List<Employee> employees;

}
