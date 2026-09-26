package hospitalmanager.controller;

import hospitalmanager.dto.request.PatientRequest;
import hospitalmanager.dto.response.ApiResponse;
import hospitalmanager.dto.response.PatientResponse;
import hospitalmanager.entity.Patient;
import hospitalmanager.service.PatientService;

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
@RequestMapping("/hospital/patients")
@RequiredArgsConstructor
public class PatientController {

    private final PatientService patientService;

    @PostMapping
    public ResponseEntity<ApiResponse<PatientResponse>> createPatient(
            @Valid @RequestBody PatientRequest request) {

        Patient patient = patientService.createPatient(request);

        PatientResponse patientResponse = PatientResponse.builder()
                .id(patient.getId())
                .name(patient.getName())
                .email(patient.getEmail())
                .phoneNumber(patient.getPhoneNumber())
                .dateOfBirth(patient.getDateOfBirth())
                .gender(patient.getGender())
                .bloodGroup(patient.getBloodGroup())
                .address(patient.getAddress())
                .build();

        ApiResponse<PatientResponse> response = ApiResponse.<PatientResponse>builder()
                .success(true)
                .message("Patient created successfully")
                .data(patientResponse)
                .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PatientResponse>> getPatientById(
            @PathVariable Long id) {

        Patient patient = patientService.getPatientById(id);

        PatientResponse patientResponse = PatientResponse.builder()
                .id(patient.getId())
                .name(patient.getName())
                .email(patient.getEmail())
                .phoneNumber(patient.getPhoneNumber())
                .dateOfBirth(patient.getDateOfBirth())
                .gender(patient.getGender())
                .bloodGroup(patient.getBloodGroup())
                .address(patient.getAddress())
                .build();

        ApiResponse<PatientResponse> response = ApiResponse.<PatientResponse>builder()
                .success(true)
                .message("Patient fetched successfully")
                .data(patientResponse)
                .build();

        return ResponseEntity.ok(response);
    }
    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<PatientResponse>>> getAllPatients(
            Pageable pageable) {

        Page<Patient> patientPage = patientService.getAllPatients(pageable);

        List<PatientResponse> patients = patientPage.getContent()
                .stream()
                .map(patient -> PatientResponse.builder()
                        .id(patient.getId())
                        .name(patient.getName())
                        .email(patient.getEmail())
                        .phoneNumber(patient.getPhoneNumber())
                        .dateOfBirth(patient.getDateOfBirth())
                        .gender(patient.getGender())
                        .bloodGroup(patient.getBloodGroup())
                        .address(patient.getAddress())
                        .build())
                .toList();

        PageResponse<PatientResponse> pageResponse =
                PageResponse.<PatientResponse>builder()
                        .content(patients)
                        .page(patientPage.getNumber())
                        .size(patientPage.getSize())
                        .totalElements(patientPage.getTotalElements())
                        .totalPages(patientPage.getTotalPages())
                        .first(patientPage.isFirst())
                        .last(patientPage.isLast())
                        .build();

        ApiResponse<PageResponse<PatientResponse>> response =
                ApiResponse.<PageResponse<PatientResponse>>builder()
                        .success(true)
                        .message("Patients fetched successfully")
                        .data(pageResponse)
                        .build();

        return ResponseEntity.ok(response);
    }
}