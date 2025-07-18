package tech.janio.medical_appointments.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Doctor {

    private UUID id;
    private User user;
    private String specialty;
    private List<AvailableSlot> availableSlots;

    public Doctor(User user, String specialty) {
        this.id = UUID.randomUUID();
        this.user = user;
        this.specialty = specialty;
    }

    public UUID getId() { return id; }
    public User getUser() { return user; }
    public String getSpecialty() { return specialty; }
    public List<AvailableSlot> getAvailableSlots() { return availableSlots; }

    public void addAvailableSlot(AvailableSlot slot) {
        if (!availableSlots.contains(slot)) {
            availableSlots.add(slot);
        }
    }

    public void removeAvailableSlot(AvailableSlot slot) {
        availableSlots.remove(slot);
    }

    public String getName() {
        return user.getName();
    }

    public String getEmail() {
        return user.getEmail();
    }

    public UUID getUserId() {
        return user.getId();
    }
}
