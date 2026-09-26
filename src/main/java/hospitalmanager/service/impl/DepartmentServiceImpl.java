package hospitalmanager.service.impl;

import org.springframework.stereotype.Service;

import hospitalmanager.dto.request.DepartmentRequest;
import hospitalmanager.entity.Department;
import hospitalmanager.exception.ResourceNotFoundException;
import hospitalmanager.repository.DepartmentRepository;
import hospitalmanager.service.DepartmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentRepository departmentRepository;

    @Override
    public Department createDepartment(DepartmentRequest request) {

        Department department = Department.builder()
                .name(request.getName())
                .description(request.getDescription())
                .build();

        return departmentRepository.save(department);
    }

    @Override
    public Department getDepartmentById(Long id) {

        return departmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Department not found with id: " + id));
    }
    
    @Override
    public Page<Department> getAllDepartments(Pageable pageable) {
        return departmentRepository.findAll(pageable);
    }
}