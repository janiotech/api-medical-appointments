package tech.janio.medical_appointments.domain.repository;

import tech.janio.medical_appointments.domain.model.Doctor;

import java.util.Optional;
import java.util.UUID;

public interface DoctorRepository {
    Doctor save(Doctor doctor);
    Optional<Doctor> findById(UUID id);
    Optional<Doctor> findByUserId(UUID userId);
}