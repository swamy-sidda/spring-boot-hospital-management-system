package hospitalmanager.service.impl;

import org.springframework.stereotype.Service;

import hospitalmanager.dto.request.PatientRequest;
import hospitalmanager.entity.Patient;
import hospitalmanager.exception.ResourceNotFoundException;
import hospitalmanager.repository.PatientRepository;
import hospitalmanager.service.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;

    @Override
    public Patient createPatient(PatientRequest request) {

        Patient patient = Patient.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .dateOfBirth(request.getDateOfBirth())
                .gender(request.getGender())
                .bloodGroup(request.getBloodGroup())
                .address(request.getAddress())
                .build();

        return patientRepository.save(patient);
    }

    @Override
    public Patient getPatientById(Long id) {

        return patientRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Patient not found with id: " + id));
    }
    @Override
    public Page<Patient> getAllPatients(Pageable pageable) {
        return patientRepository.findAll(pageable);
    }
}