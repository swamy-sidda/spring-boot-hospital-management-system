package hospitalmanager.service;

import hospitalmanager.dto.request.LoginRequest;
import hospitalmanager.dto.response.AuthResponse;

public interface AuthService {

    AuthResponse login(LoginRequest request);
}