package tech.janio.medical_appointments.domain.repositories;

import tech.janio.medical_appointments.domain.model.Patient;

import java.util.Optional;
import java.util.UUID;

public interface PatientRepository {
    Patient save(Patient patient);

    Optional<Patient> findById(UUID id);

    Optional<Patient> findByUserId(UUID userId);
}