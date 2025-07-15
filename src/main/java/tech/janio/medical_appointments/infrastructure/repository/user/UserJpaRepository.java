package tech.janio.medical_appointments.infrastructure.repository.user;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.janio.medical_appointments.infrastructure.entity.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface UserJpaRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmail(String email);
    boolean existsByEmail(String email);
}