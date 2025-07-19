package tech.janio.medical_appointments.infrastructure.dto;

import tech.janio.medical_appointments.domain.model.Doctor;
import tech.janio.medical_appointments.domain.model.User;

public class DoctorResponse {
    private String id;
    private User user;
    private String specialty;

    public static DoctorResponse fromDomain(Doctor doctor) {
        DoctorResponse response = new DoctorResponse();
        response.setId(doctor.getId().toString());
        response.setUser(doctor.getUser());
        response.setSpecialty(doctor.getSpecialty());
        return response;
    }

    // Getters e Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUser() { return user.toString(); }
    public void setUser(User user) { this.user = user; }

    public String getSpecialty() { return specialty; }
    public void setSpecialty(String specialty) { this.specialty = specialty; }
}
