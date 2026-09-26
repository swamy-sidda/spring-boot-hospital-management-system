package hospitalmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hospitalmanager.entity.Appointment;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}