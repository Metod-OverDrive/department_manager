package com.practice.departmentManager.web.controller;

import com.practice.departmentManager.domain.employee.Employee;
import com.practice.departmentManager.service.AuthService;
import com.practice.departmentManager.service.EmployeeService;
import com.practice.departmentManager.web.dto.auth.JwtResponse;
import com.practice.departmentManager.web.dto.auth.LoginRequest;
import com.practice.departmentManager.web.dto.auth.RefreshToken;
import com.practice.departmentManager.web.dto.employee.EmployeeDto;
import com.practice.departmentManager.web.dto.validation.OnCreate;
import com.practice.departmentManager.web.mapper.EmployeeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@Validated
public class AuthControllerV1 {

    private final AuthService authService;
    private final EmployeeService employeeService;

    private final EmployeeMapper employeeMapper;

    @PostMapping("/login")
    public JwtResponse login(@Validated @RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

    @PostMapping("/register/{depid}")
    public EmployeeDto register(@Validated(OnCreate.class) @RequestBody EmployeeDto employeeDto,
                                @PathVariable("depid") Long id) {
        Employee employee = employeeMapper.toEntity(employeeDto);
        Employee createdEmployee = employeeService.create(employee, id);
        return employeeMapper.toDto(createdEmployee);
    }

    @PostMapping("/refresh")
    public JwtResponse refresh(@Validated @RequestBody RefreshToken refreshToken) {
        return authService.refresh(refreshToken);
    }

}
