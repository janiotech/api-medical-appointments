package tech.janio.medical_appointments.application.dto.user;

import tech.janio.medical_appointments.domain.enums.RoleEnum;
import tech.janio.medical_appointments.domain.model.User;

import java.time.OffsetDateTime;
import java.util.Set;
import java.util.UUID;

public class UserResponse {
    private UUID id;
    private String name;
    private String email;
    private Set<RoleEnum> role;
    private OffsetDateTime createdAt;
    private OffsetDateTime updatedAt;

    public static UserResponse fromDomain(User user) {
        UserResponse response = new UserResponse();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setRole(user.getRoles());
        response.setCreatedAt(user.getCreatedAt());
        response.setUpdatedAt(user.getUpdatedAt());
        return response;
    }

    public UUID getId() { return id; }
    public void setId(UUID id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Set<RoleEnum> getRole() { return role; }
    public void setRole(Set<RoleEnum> role) { this.role= role; }

    public OffsetDateTime getCreatedAt() { return createdAt; }
    public void setCreatedAt(OffsetDateTime createdAt) { this.createdAt = createdAt; }

    public OffsetDateTime getUpdatedAt() { return updatedAt; }
    public void setUpdatedAt(OffsetDateTime updatedAt) { this.updatedAt = updatedAt; }
}
