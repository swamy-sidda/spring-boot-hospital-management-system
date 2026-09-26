package hospitalmanager.controller;

import hospitalmanager.dto.request.AppointmentRequest;
import hospitalmanager.dto.response.ApiResponse;
import hospitalmanager.dto.response.AppointmentResponse;
import hospitalmanager.entity.Appointment;
import hospitalmanager.service.AppointmentService;

import jakarta.validation.Valid;

import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import hospitalmanager.dto.response.PageResponse;

@RestController
@RequestMapping("/hospital/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public ResponseEntity<ApiResponse<AppointmentResponse>> createAppointment(
            @Valid @RequestBody AppointmentRequest request) {

        Appointment appointment = appointmentService.createAppointment(request);

        AppointmentResponse appointmentResponse = AppointmentResponse.builder()
                .id(appointment.getId())
                .patientId(appointment.getPatientId())
                .doctorId(appointment.getDoctorId())
                .departmentId(appointment.getDepartmentId())
                .appointmentDate(appointment.getAppointmentDate())
                .appointmentTime(appointment.getAppointmentTime())
                .reason(appointment.getReason())
                .status(appointment.getStatus())
                .createdAt(appointment.getCreatedAt())
                .updatedAt(appointment.getUpdatedAt())
                .build();

        ApiResponse<AppointmentResponse> response =
                ApiResponse.<AppointmentResponse>builder()
                        .success(true)
                        .message("Appointment created successfully")
                        .data(appointmentResponse)
                        .build();

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<AppointmentResponse>> getAppointmentById(
            @PathVariable Long id) {

        Appointment appointment = appointmentService.getAppointmentById(id);

        AppointmentResponse appointmentResponse = AppointmentResponse.builder()
                .id(appointment.getId())
                .patientId(appointment.getPatientId())
                .doctorId(appointment.getDoctorId())
                .departmentId(appointment.getDepartmentId())
                .appointmentDate(appointment.getAppointmentDate())
                .appointmentTime(appointment.getAppointmentTime())
                .reason(appointment.getReason())
                .status(appointment.getStatus())
                .createdAt(appointment.getCreatedAt())
                .updatedAt(appointment.getUpdatedAt())
                .build();

        ApiResponse<AppointmentResponse> response =
                ApiResponse.<AppointmentResponse>builder()
                        .success(true)
                        .message("Appointment fetched successfully")
                        .data(appointmentResponse)
                        .build();

        return ResponseEntity.ok(response);
    }
    
    @GetMapping
    public ResponseEntity<ApiResponse<PageResponse<AppointmentResponse>>> getAllAppointments(
            Pageable pageable) {

        Page<Appointment> appointmentPage =
                appointmentService.getAllAppointments(pageable);

        List<AppointmentResponse> appointments = appointmentPage.getContent()
                .stream()
                .map(appointment -> AppointmentResponse.builder()
                        .id(appointment.getId())
                        .patientId(appointment.getPatientId())
                        .doctorId(appointment.getDoctorId())
                        .departmentId(appointment.getDepartmentId())
                        .appointmentDate(appointment.getAppointmentDate())
                        .appointmentTime(appointment.getAppointmentTime())
                        .reason(appointment.getReason())
                        .status(appointment.getStatus())
                        .createdAt(appointment.getCreatedAt())
                        .updatedAt(appointment.getUpdatedAt())
                        .build())
                .toList();

        PageResponse<AppointmentResponse> pageResponse =
                PageResponse.<AppointmentResponse>builder()
                        .content(appointments)
                        .page(appointmentPage.getNumber())
                        .size(appointmentPage.getSize())
                        .totalElements(appointmentPage.getTotalElements())
                        .totalPages(appointmentPage.getTotalPages())
                        .first(appointmentPage.isFirst())
                        .last(appointmentPage.isLast())
                        .build();

        ApiResponse<PageResponse<AppointmentResponse>> response =
                ApiResponse.<PageResponse<AppointmentResponse>>builder()
                        .success(true)
                        .message("Appointments fetched successfully")
                        .data(pageResponse)
                        .build();

        return ResponseEntity.ok(response);
    }
}