package com.practice.departmentManager.service.impl;

import com.practice.departmentManager.domain.employee.Employee;
import com.practice.departmentManager.security.JwtProvider;
import com.practice.departmentManager.service.AuthService;
import com.practice.departmentManager.service.EmployeeService;
import com.practice.departmentManager.web.dto.auth.JwtResponse;
import com.practice.departmentManager.web.dto.auth.LoginRequest;
import com.practice.departmentManager.web.dto.auth.RefreshToken;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final AuthenticationManager authenticationManager;
    private final EmployeeService employeeService;
    private final JwtProvider jwtProvider;

    @Override
    public JwtResponse login(LoginRequest loginRequest) {
        JwtResponse jwtResponse = new JwtResponse();
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginRequest.getUsername(), loginRequest.getPassword())
        );
        Employee employee = employeeService.getByUsername(loginRequest.getUsername());
        jwtResponse.setId(employee.getId());
        jwtResponse.setUsername(employee.getUsername());
        jwtResponse.setAccessToken(jwtProvider.createAccessToken(
                employee.getId(), employee.getUsername(), employee.getRoles())
        );
        jwtResponse.setRefreshToken(jwtProvider.createRefreshToken(
                employee.getId(), employee.getUsername())
        );
        return jwtResponse;
    }

    @Override
    public JwtResponse refresh(RefreshToken refreshToken) {
        return jwtProvider.refreshUserToken(refreshToken.getRefreshToken());
    }

}
