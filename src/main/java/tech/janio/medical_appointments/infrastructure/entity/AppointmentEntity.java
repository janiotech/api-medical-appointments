package tech.janio.medical_appointments.infrastructure.entity;

import jakarta.persistence.*;

import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "appointments")
public class AppointmentEntity {

    @Id
    private UUID id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "patient_id", referencedColumnName = "id")
    private PatientEntity patient;

    @ManyToOne(optional = false)
    @JoinColumn(name = "doctor_id", referencedColumnName = "id")
    private DoctorEntity doctor;

    @Column(name = "start_time", nullable = false)
    private OffsetDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private OffsetDateTime endTime;

    public AppointmentEntity() {}

    public AppointmentEntity(UUID id, PatientEntity patient, DoctorEntity doctor, OffsetDateTime startTime, OffsetDateTime endTime) {
        this.id = id;
        this.patient = patient;
        this.doctor = doctor;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public UUID getId() { return id; }
    public PatientEntity getPatient() { return patient; }
    public DoctorEntity getDoctor() { return doctor; }
    public OffsetDateTime getStartTime() { return startTime; }
    public OffsetDateTime getEndTime() { return endTime; }

    public void setId(UUID id) { this.id = id; }
    public void setPatient(PatientEntity patient) { this.patient = patient; }
    public void setDoctor(DoctorEntity doctor) { this.doctor = doctor; }
    public void setStartTime(OffsetDateTime startTime) { this.startTime = startTime; }
    public void setEndTime(OffsetDateTime endTime) { this.endTime = endTime; }
}