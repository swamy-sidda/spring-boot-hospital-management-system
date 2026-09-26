package hospitalmanager.service;

import hospitalmanager.dto.request.AppointmentRequest;
import hospitalmanager.entity.Appointment;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AppointmentService {

    Appointment createAppointment(AppointmentRequest request);

    Appointment getAppointmentById(Long id);
    
    Page<Appointment> getAllAppointments(Pageable pageable);
}