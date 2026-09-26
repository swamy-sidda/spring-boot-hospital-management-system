package hospitalmanager.controller;

import hospitalmanager.dto.request.DepartmentRequest;
import hospitalmanager.dto.response.ApiResponse;
import hospitalmanager.dto.response.DepartmentResponse;
import hospitalmanager.entity.Department;
import hospitalmanager.service.DepartmentService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import hospitalmanager.dto.response.PageResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospital/departments")
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<ApiResponse<DepartmentResponse>> createDepartment(
            @Valid @RequestBody DepartmentRequest request) {

        Department department = departmentService.createDepartment(request);

        DepartmentResponse departmentResponse = DepartmentResponse.builder()
                .id(department.getId())
                .name(department.getName())
                .description(department.getDescription())
                .createdAt(department.getCreatedAt())
                .updatedAt(department.getUpdatedAt())
                .build();

        ApiResponse<DepartmentResponse> response =
                ApiResponse.<DepartmentResponse>builder()
                        .success(true)
                        .message("Department created successfully")
                        .data(departmentResponse)
                        .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DepartmentResponse>> getDepartmentById(
            @PathVariable Long id) {

        Department department = departmentService.getDepartmentById(id);

        DepartmentResponse departmentResponse = DepartmentResponse.builder()
                .id(department.getId())
                .name(department.getName())
                .description(department.getDescription())
                .createdAt(department.getCreatedAt())
                .updatedAt(department.getUpdatedAt())
                .build();

        ApiResponse<DepartmentResponse> response =
                ApiResponse.<DepartmentResponse>builder()
                        .success(true)
                        .message("Department fetched successfully")
                        .data(departmentResponse)
                        .build();

        return ResponseEntity.ok(response);
    }
    
    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<DepartmentResponse>>> getAllDepartments(
            Pageable pageable) {

        Page<Department> departmentPage =
                departmentService.getAllDepartments(pageable);

        List<DepartmentResponse> departments = departmentPage.getContent()
                .stream()
                .map(department -> DepartmentResponse.builder()
                        .id(department.getId())
                        .name(department.getName())
                        .description(department.getDescription())
                        .createdAt(department.getCreatedAt())
                        .updatedAt(department.getUpdatedAt())
                        .build())
                .toList();

        PageResponse<DepartmentResponse> pageResponse =
                PageResponse.<DepartmentResponse>builder()
                        .content(departments)
                        .page(departmentPage.getNumber())
                        .size(departmentPage.getSize())
                        .totalElements(departmentPage.getTotalElements())
                        .totalPages(departmentPage.getTotalPages())
                        .first(departmentPage.isFirst())
                        .last(departmentPage.isLast())
                        .build();

        ApiResponse<PageResponse<DepartmentResponse>> response =
                ApiResponse.<PageResponse<DepartmentResponse>>builder()
                        .success(true)
                        .message("Departments fetched successfully")
                        .data(pageResponse)
                        .build();

        return ResponseEntity.ok(response);
    }
}