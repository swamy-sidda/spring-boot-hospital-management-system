package hospitalmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import hospitalmanager.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}