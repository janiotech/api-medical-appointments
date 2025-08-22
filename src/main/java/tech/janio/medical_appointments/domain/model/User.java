package tech.janio.medical_appointments.domain.model;

import tech.janio.medical_appointments.domain.enums.RoleEnum;
import tech.janio.medical_appointments.domain.exceptions.DomainException;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Set;
import java.util.UUID;
import java.util.regex.Pattern;

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
        this.name = validateName(name);
        this.email = validateEmail(email);
        this.passwordHash = ValidatePassword(passwordHash);
        this.roles = Set.of(RoleEnum.USER);
        this.createdAt = OffsetDateTime.now(ZoneOffset.UTC);
        this.updatedAt = OffsetDateTime.now(ZoneOffset.UTC);
    }

    public User(UUID id, String name, String email, String passwordHash, Set<RoleEnum> roles,
                OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.name = validateName(name);
        this.email = validateEmail(email);
        this.passwordHash = ValidatePassword(passwordHash);
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

    private String validateName(String name) {
        if (name == null || name.length() < 5 || name.trim().isEmpty()) {
            throw new DomainException(400, "Name cannot be null or empty.");
        }
        return name;
    }

    private String validateEmail(String email) {
        if (email == null || (!email.endsWith("@gmail.com") && !email.endsWith("@hotmail.com"))) {
            throw new DomainException(400,"Invalid email format. Only Gmail and Hotmail are allowed.");
        }
        return email;
    }

    private String ValidatePassword(String password) {
        if (password == null || password.length() < 8) {
            throw new DomainException(400, "Password must be at least 8 characters long.");
        }
        return password;
    }
}
