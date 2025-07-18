package tech.janio.medical_appointments.infrastructure.repository.patient;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.janio.medical_appointments.infrastructure.entity.PatientEntity;

import java.util.UUID;

public interface PatientJpaRepository extends JpaRepository<PatientEntity, UUID> {
}