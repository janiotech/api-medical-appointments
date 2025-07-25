package tech.janio.medical_appointments.infrastructure.entity;


import jakarta.persistence.*;
import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import tech.janio.medical_appointments.domain.enums.RoleEnum;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    private UUID id;

    private String name;

    @Column(unique = true, nullable = false)
    private String email;

    private String password;

    @JoinTable(
        name = "user_roles",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<RoleEnum> roles;

    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public UserEntity(UUID id, String name, String email, String passwordHash, Set<RoleEnum> roles, OffsetDateTime createdAt, OffsetDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = passwordHash;
        this.roles = roles;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public UserEntity() {

    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public Set<RoleEnum> getRoles() {
        return roles;
    }
    public void setRoles(Set<RoleEnum> roles) { this.roles = roles; }

    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }

    public OffsetDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(OffsetDateTime updatedAt) { this.updatedAt = updatedAt; }
}
