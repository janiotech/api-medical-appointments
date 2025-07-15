package tech.janio.medical_appointments.infrastructure.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "available_slots")
public class AvailableSlotEntity {

    @Id
    private UUID id;

    private OffsetDateTime dateTime;

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public OffsetDateTime getDateTime() { return dateTime; }
    public void setDateTime(OffsetDateTime dateTime) { this.dateTime = dateTime; }
}
