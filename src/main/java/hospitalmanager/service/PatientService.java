package hospitalmanager.service;

import hospitalmanager.dto.request.PatientRequest;
import hospitalmanager.entity.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface PatientService {

    Patient createPatient(PatientRequest request);

    Patient getPatientById(Long id);
    Page<Patient> getAllPatients(Pageable pageable);
}