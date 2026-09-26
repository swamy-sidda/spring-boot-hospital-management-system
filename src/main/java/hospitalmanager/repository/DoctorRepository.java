package hospitalmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hospitalmanager.entity.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {

}