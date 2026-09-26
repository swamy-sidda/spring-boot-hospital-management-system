package hospitalmanager.controller;

import hospitalmanager.dto.request.UserRequest;
import hospitalmanager.entity.User;
import hospitalmanager.service.UserService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import hospitalmanager.dto.response.ApiResponse;
import hospitalmanager.dto.response.PageResponse;
import hospitalmanager.dto.response.UserResponse;

import org.springframework.data.domain.Page;

@RestController
@RequestMapping("/hospital/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<User> createUser(
            @Valid @RequestBody UserRequest request) {

        User user = userService.createUser(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(user);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(
            @PathVariable Long id) {

        User user = userService.getUserById(id);

        return ResponseEntity.ok(user);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<UserResponse>>> getAllUsers(
            Pageable pageable) {

        Page<User> userPage = userService.getAllUsers(pageable);

        List<UserResponse> users = userPage.getContent()
                .stream()
                .map(user -> UserResponse.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .phoneNumber(user.getPhoneNumber())
                        .role(user.getRole())
                        .active(user.getActive())
                        .build())
                .toList();

        PageResponse<UserResponse> pageResponse =
                PageResponse.<UserResponse>builder()
                        .content(users)
                        .page(userPage.getNumber())
                        .size(userPage.getSize())
                        .totalElements(userPage.getTotalElements())
                        .totalPages(userPage.getTotalPages())
                        .first(userPage.isFirst())
                        .last(userPage.isLast())
                        .build();

        ApiResponse<PageResponse<UserResponse>> response =
                ApiResponse.<PageResponse<UserResponse>>builder()
                        .success(true)
                        .message("Users fetched successfully")
                        .data(pageResponse)
                        .build();

        return ResponseEntity.ok(response);
    }
}