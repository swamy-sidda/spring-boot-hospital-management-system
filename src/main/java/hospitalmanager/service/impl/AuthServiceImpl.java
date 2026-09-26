package hospitalmanager.service.impl;

import org.springframework.stereotype.Service;

import hospitalmanager.dto.request.LoginRequest;
import hospitalmanager.dto.response.AuthResponse;
import hospitalmanager.entity.User;
import hospitalmanager.exception.ResourceNotFoundException;
import hospitalmanager.repository.UserRepository;
import hospitalmanager.security.JwtService;
import hospitalmanager.service.AuthService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final JwtService jwtService;

    @Override
    public AuthResponse login(LoginRequest request) {

        User user = userRepository.findAll()
                .stream()
                .filter(u -> u.getEmail().equals(request.getEmail()))
                .findFirst()
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found"));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        String token = jwtService.generateToken(
                user.getId(),
                user.getEmail(),
                user.getRole()
        );

        return AuthResponse.builder()
                .userId(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .role(user.getRole())
                .token(token)
                .message("Login successful")
                .build();
    }
}