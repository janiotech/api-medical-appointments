package tech.janio.medical_appointments.domain.model;

import tech.janio.medical_appointments.domain.enums.Role;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Set;
import java.util.UUID;

public class User {

    private UUID id;
    private String name;
    private String email;
    private String passwordHash;
    private Set<Role> roles;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public User(String name, String email, String passwordHash, Set<Role> roles) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.email = email;
        this.passwordHash = passwordHash;
        this.roles = roles;
        this.createdAt = OffsetDateTime.now(ZoneOffset.UTC);
        this.updatedAt = OffsetDateTime.now(ZoneOffset.UTC);
    }

    public UUID getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPasswordHash() { return passwordHash; }
    public Set<Role> getRoles() { return roles; }
    public OffsetDateTime getCreatedAt() { return createdAt; }
    public OffsetDateTime getUpdatedAt() { return updatedAt; }

    public boolean hasRole(Role role) {
        return roles.contains(role);
    }

    public void updateTimestamps() {
        this.updatedAt = OffsetDateTime.now(ZoneOffset.UTC);
    }
}
