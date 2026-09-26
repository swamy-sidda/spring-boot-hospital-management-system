package hospitalmanager.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import hospitalmanager.dto.request.UserRequest;
import hospitalmanager.entity.User;

public interface UserService {

    User createUser(UserRequest request);

    User getUserById(Long id);

    Page<User> getAllUsers(Pageable pageable);
}