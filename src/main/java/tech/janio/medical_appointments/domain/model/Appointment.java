package tech.janio.medical_appointments.domain.model;

import java.time.OffsetDateTime;
import java.util.UUID;

public class Appointment {

    private UUID id;
    private Doctor doctor;
    private Patient patient;
    private OffsetDateTime dateTime;

    public Appointment(Doctor doctor, Patient patient, OffsetDateTime dateTime) {
        this.id = UUID.randomUUID();
        this.doctor = doctor;
        this.patient = patient;
        this.dateTime = dateTime;
    }

    public UUID getId() {
        return id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public OffsetDateTime getDateTime() {
        return dateTime;
    }

    public UUID getDoctorId() {
        return doctor.getId();
    }

    public UUID getPatientId() {
        return patient.getId();
    }
}
