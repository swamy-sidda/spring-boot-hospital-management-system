package hospitalmanager.service;

import hospitalmanager.dto.request.DoctorRequest;
import hospitalmanager.entity.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface DoctorService {

    Doctor createDoctor(DoctorRequest request);

    Doctor getDoctorById(Long id);
    Page<Doctor> getAllDoctors(Pageable pageable);
}