package hospitalmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hospitalmanager.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {

}