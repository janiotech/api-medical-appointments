package tech.janio.medical_appointments.infrastructure.repository.appointment;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.janio.medical_appointments.infrastructure.entity.AppointmentEntity;

import java.util.UUID;

public interface AppointmentJpaRepository extends JpaRepository<AppointmentEntity, UUID> {
}
