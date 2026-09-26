package hospitalmanager.service.impl;

import org.springframework.stereotype.Service;

import hospitalmanager.dto.request.AppointmentRequest;
import hospitalmanager.entity.Appointment;
import hospitalmanager.exception.ResourceNotFoundException;
import hospitalmanager.repository.AppointmentRepository;
import hospitalmanager.service.AppointmentService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository appointmentRepository;

    @Override
    public Appointment createAppointment(AppointmentRequest request) {

        Appointment appointment = Appointment.builder()
                .patientId(request.getPatientId())
                .doctorId(request.getDoctorId())
                .departmentId(request.getDepartmentId())
                .appointmentDate(request.getAppointmentDate())
                .appointmentTime(request.getAppointmentTime())
                .reason(request.getReason())
                .status("SCHEDULED")
                .build();

        return appointmentRepository.save(appointment);
    }

    @Override
    public Appointment getAppointmentById(Long id) {

        return appointmentRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Appointment not found with id: " + id));
    }
    
    @Override
    public Page<Appointment> getAllAppointments(Pageable pageable) {
        return appointmentRepository.findAll(pageable);
    }
}