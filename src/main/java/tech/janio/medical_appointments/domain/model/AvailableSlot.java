package tech.janio.medical_appointments.domain.model;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

public class AvailableSlot {

    private UUID id;
    private OffsetDateTime dateTime;

    public AvailableSlot(OffsetDateTime dateTime) {
        this.id = UUID.randomUUID();
        this.dateTime = dateTime;
    }

    public UUID getId() { return id; }

    public OffsetDateTime getDateTime() { return dateTime; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AvailableSlot)) return false;
        AvailableSlot that = (AvailableSlot) o;
        return dateTime.equals(that.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dateTime);
    }
}
