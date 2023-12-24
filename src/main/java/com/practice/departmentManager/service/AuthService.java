package com.practice.departmentManager.service;

import com.practice.departmentManager.web.dto.auth.JwtResponse;
import com.practice.departmentManager.web.dto.auth.LoginRequest;
import com.practice.departmentManager.web.dto.auth.RefreshToken;

public interface AuthService {

    JwtResponse login(LoginRequest request);

    JwtResponse refresh(RefreshToken refreshToken);
}
