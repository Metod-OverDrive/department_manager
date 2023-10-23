package com.practice.departmentManager.web.dto.employee;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.practice.departmentManager.web.dto.validation.OnCreate;
import com.practice.departmentManager.web.dto.validation.OnUpdate;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

@Getter
@Setter
public class EmployeeDto {

    @NotNull(message = "Id must be not null", groups = OnUpdate.class)
    private Long id;

    @NotNull(message = "Name must be not null", groups = {OnUpdate.class, OnCreate.class})
    @Length(max = 255, message = "Name length must be smaller than 255 symbols",
            groups = {OnUpdate.class, OnCreate.class})
    private String name;

    @NotNull(message = "Surname must be not null", groups = {OnUpdate.class, OnCreate.class})
    @Length(max = 255, message = "Surname length must be smaller than 255 symbols",
            groups = {OnUpdate.class, OnCreate.class})
    private String surname;

    @NotNull(message = "Username must be not null", groups = {OnUpdate.class, OnCreate.class})
    @Length(max = 255, message = "Username length must be smaller than 255 symbols",
            groups = {OnUpdate.class, OnCreate.class})
    private String username;

    @NotNull(message = "PhoneNumber must be not null", groups = {OnUpdate.class, OnCreate.class})
    private String phoneNumber;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotNull(message = "Password must be not null", groups = {OnUpdate.class, OnCreate.class})
    private String password;

    @NotNull(message = "Salary must be not null", groups = {OnUpdate.class, OnCreate.class})
    private Float salary;

    @NotNull(message = "Must be active or not", groups = {OnUpdate.class, OnCreate.class})
    private Boolean isActive;
}
