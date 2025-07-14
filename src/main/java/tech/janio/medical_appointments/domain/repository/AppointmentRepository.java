package tech.janio.medical_appointments.domain.repository;

import tech.janio.medical_appointments.domain.model.Appointment;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface AppointmentRepository {
    Appointment save(Appointment appointment);
    Optional<Appointment> findById(UUID id);
    List<Appointment> findByDoctorId(UUID doctorId);
    List<Appointment> findByPatientId(UUID patientId);
    boolean existsByDoctorIdAndDateTime(UUID doctorId, OffsetDateTime dateTime);
}
