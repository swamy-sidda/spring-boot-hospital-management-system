package hospitalmanager.service.impl;

import org.springframework.stereotype.Service;

import hospitalmanager.dto.request.DoctorRequest;
import hospitalmanager.entity.Doctor;
import hospitalmanager.exception.ResourceNotFoundException;
import hospitalmanager.repository.DoctorRepository;
import hospitalmanager.service.DoctorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DoctorServiceImpl implements DoctorService {

    private final DoctorRepository doctorRepository;
    @Override
    public Page<Doctor> getAllDoctors(Pageable pageable) {
        return doctorRepository.findAll(pageable);
    }

    @Override
    public Doctor createDoctor(DoctorRequest request) {

        Doctor doctor = Doctor.builder()
                .name(request.getName())
                .email(request.getEmail())
                .phoneNumber(request.getPhoneNumber())
                .specialization(request.getSpecialization())
                .qualification(request.getQualification())
                .experience(request.getExperience())
                .consultationFee(request.getConsultationFee())
                .available(request.getAvailable())
                .build();

        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor getDoctorById(Long id) {

        return doctorRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Doctor not found with id: " + id));
    }
}