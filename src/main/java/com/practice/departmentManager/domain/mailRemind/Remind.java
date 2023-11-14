package com.practice.departmentManager.domain.mailRemind;

import com.practice.departmentManager.domain.employee.Employee;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Builder
@EqualsAndHashCode
public class Remind {

    private String taskTitle;
    private String taskDescription;
    private Date expirationDate;
    private List<Employee> employees;

}
