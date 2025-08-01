package tech.janio.medical_appointments.domain.repository;

import tech.janio.medical_appointments.domain.model.User;
import tech.janio.medical_appointments.application.dto.user.UserResponse;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(UUID id);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    List<UserResponse> findAllPaginated(int page, int size);
    long countAll();
}
