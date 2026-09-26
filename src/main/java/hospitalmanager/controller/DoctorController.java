package hospitalmanager.controller;

import hospitalmanager.dto.request.DoctorRequest;
import hospitalmanager.dto.response.ApiResponse;
import hospitalmanager.dto.response.DoctorResponse;
import hospitalmanager.entity.Doctor;
import hospitalmanager.service.DoctorService;

import jakarta.validation.Valid;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import hospitalmanager.dto.response.PageResponse;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hospital/doctors")
@RequiredArgsConstructor
public class DoctorController {

    private final DoctorService doctorService;

    @PostMapping
    public ResponseEntity<ApiResponse<DoctorResponse>> createDoctor(
            @Valid @RequestBody DoctorRequest request) {

        Doctor doctor = doctorService.createDoctor(request);

        DoctorResponse doctorResponse = DoctorResponse.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .email(doctor.getEmail())
                .phoneNumber(doctor.getPhoneNumber())
                .specialization(doctor.getSpecialization())
                .qualification(doctor.getQualification())
                .experience(doctor.getExperience())
                .consultationFee(doctor.getConsultationFee())
                .available(doctor.getAvailable())
                .build();

        ApiResponse<DoctorResponse> response = ApiResponse.<DoctorResponse>builder()
                .success(true)
                .message("Doctor created successfully")
                .data(doctorResponse)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<DoctorResponse>> getDoctorById(
            @PathVariable Long id) {

        Doctor doctor = doctorService.getDoctorById(id);

        DoctorResponse doctorResponse = DoctorResponse.builder()
                .id(doctor.getId())
                .name(doctor.getName())
                .email(doctor.getEmail())
                .phoneNumber(doctor.getPhoneNumber())
                .specialization(doctor.getSpecialization())
                .qualification(doctor.getQualification())
                .experience(doctor.getExperience())
                .consultationFee(doctor.getConsultationFee())
                .available(doctor.getAvailable())
                .build();

        ApiResponse<DoctorResponse> response = ApiResponse.<DoctorResponse>builder()
                .success(true)
                .message("Doctor fetched successfully")
                .data(doctorResponse)
                .build();

        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<DoctorResponse>>> getAllDoctors(
            Pageable pageable) {

        Page<Doctor> doctorPage = doctorService.getAllDoctors(pageable);

        List<DoctorResponse> doctors = doctorPage.getContent()
                .stream()
                .map(doctor -> DoctorResponse.builder()
                        .id(doctor.getId())
                        .name(doctor.getName())
                        .email(doctor.getEmail())
                        .phoneNumber(doctor.getPhoneNumber())
                        .specialization(doctor.getSpecialization())
                        .qualification(doctor.getQualification())
                        .experience(doctor.getExperience())
                        .consultationFee(doctor.getConsultationFee())
                        .available(doctor.getAvailable())
                        .build())
                .toList();

        PageResponse<DoctorResponse> pageResponse =
                PageResponse.<DoctorResponse>builder()
                        .content(doctors)
                        .page(doctorPage.getNumber())
                        .size(doctorPage.getSize())
                        .totalElements(doctorPage.getTotalElements())
                        .totalPages(doctorPage.getTotalPages())
                        .first(doctorPage.isFirst())
                        .last(doctorPage.isLast())
                        .build();

        ApiResponse<PageResponse<DoctorResponse>> response =
                ApiResponse.<PageResponse<DoctorResponse>>builder()
                        .success(true)
                        .message("Doctors fetched successfully")
                        .data(pageResponse)
                        .build();

        return ResponseEntity.ok(response);
    }
}