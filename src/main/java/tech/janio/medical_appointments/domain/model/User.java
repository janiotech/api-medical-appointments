package tech.janio.medical_appointments.domain.model;

import tech.janio.medical_appointments.domain.enums.RoleEnum;
import tech.janio.medical_appointments.domain.exceptions.DomainException;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Set;
import java.util.UUID;

public class User {

    private UUID id;
    private String name;
    private String email;
    private String passwordHash;
    private Set<RoleEnum> roles;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public User(String name, String email, String passwordHash) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = validateEmail(email);
        this.passwordHash = passwordHash;
        this.roles = Set.of(RoleEnum.USER);
        this.createdAt = OffsetDateTime.now(ZoneOffset.UTC);
        this.updatedAt = OffsetDateTime.now(ZoneOffset.UTC);
    }

    public User(UUID id, String name, String email, String passwordHash, Set<RoleEnum> roles,
                OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.email = validateEmail(email);
        this.passwordHash = passwordHash;
        this.roles = roles;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPasswordHash() { return passwordHash; }
    public Set<RoleEnum> getRoles() { return roles; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
    public OffsetDateTime getUpdatedAt() { return updatedAt; }

    public void updateTimestamps() {
        this.updatedAt = OffsetDateTime.now(ZoneOffset.UTC);
    }

    private String validateEmail(String email) {
        if (email == null || (!email.endsWith("@gmail.com") && !email.endsWith("@hotmail.com"))) {
            throw new DomainException(400,"Invalid email format. Only Gmail and Hotmail are allowed.");
        }
        return email;
    }
}
