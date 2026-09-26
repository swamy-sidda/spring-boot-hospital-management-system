package hospitalmanager.service.impl;

import org.springframework.stereotype.Service;

import hospitalmanager.dto.request.UserRequest;
import hospitalmanager.entity.User;
import hospitalmanager.exception.ResourceNotFoundException;
import hospitalmanager.repository.UserRepository;
import hospitalmanager.service.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser(UserRequest request) {

        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .phoneNumber(request.getPhoneNumber())
                .role("PATIENT")
                .active(true)
                .build();

        return userRepository.save(user);
    }

    @Override
    public User getUserById(Long id) {

        return userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with id: " + id));
    }
    @Override
    public Page<User> getAllUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}