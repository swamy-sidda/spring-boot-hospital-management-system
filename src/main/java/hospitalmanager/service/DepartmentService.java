package hospitalmanager.service;

import hospitalmanager.dto.request.DepartmentRequest;
import hospitalmanager.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DepartmentService {

    Department createDepartment(DepartmentRequest request);

    Department getDepartmentById(Long id);
    
    Page<Department> getAllDepartments(Pageable pageable);
}