package tech.janio.medical_appointments.infrastructure.repository.doctor;

import jakarta.persistence.*;
import tech.janio.medical_appointments.infrastructure.entity.AvailableSlotEntity;
import tech.janio.medical_appointments.infrastructure.entity.UserEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "doctors")
public class DoctorEntity {

    @Id
    private UUID id;

    @OneToOne
    @JoinColumn(name = "user_id", unique = true, nullable = false)
    private UserEntity user;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "doctor_id")
    private List<AvailableSlotEntity> availableSlots = new ArrayList<>();

    // Getters and setters

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public UserEntity getUser() { return user; }
    public void setUser(UserEntity user) { this.user = user; }

    public List<AvailableSlotEntity> getAvailableSlots() { return availableSlots; }
    public void setAvailableSlots(List<AvailableSlotEntity> availableSlots) { this.availableSlots = availableSlots; }
}