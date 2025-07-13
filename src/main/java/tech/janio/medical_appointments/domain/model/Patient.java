package tech.janio.medical_appointments.domain.model;

import java.util.UUID;

public class Patient {

    private UUID id;
    private User user;

    public Patient(User user) {
        this.id = UUID.randomUUID();
        this.user = user;
    }

    public UUID getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public UUID getUserId() {
        return user.getId();
    }

    public String getName() {
        return user.getName();
    }

    public String getEmail() {
        return user.getEmail();
    }
}

