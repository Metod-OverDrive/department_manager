package com.practice.departmentManager.service;

import com.practice.departmentManager.web.dto.auth.JwtResponse;
import com.practice.departmentManager.web.dto.auth.LoginRequest;

public interface AuthService {

    JwtResponse login(LoginRequest request);

    JwtResponse refresh(String refreshToken);
}
