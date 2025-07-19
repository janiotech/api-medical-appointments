package tech.janio.medical_appointments.infrastructure.dto;

import tech.janio.medical_appointments.domain.model.Doctor;
import tech.janio.medical_appointments.domain.model.User;

public class CreateDoctorRequest {
    private User user;
    private String specialty;

    public Doctor toDomain() {
        return new Doctor(user, specialty);
    }

    // Getters e Setters
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
}
