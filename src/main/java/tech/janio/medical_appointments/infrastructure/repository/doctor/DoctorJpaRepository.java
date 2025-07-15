package tech.janio.medical_appointments.infrastructure.repository.doctor;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.janio.medical_appointments.infrastructure.entity.DoctorEntity;

import java.util.Optional;
import java.util.UUID;

public interface DoctorJpaRepository extends JpaRepository<DoctorEntity, UUID> {
    Optional<DoctorEntity> findByUserId(UUID userId);
}
