package tech.janio.medical_appointments.infrastructure.dto;

import tech.janio.medical_appointments.domain.enums.RoleEnum;
import tech.janio.medical_appointments.domain.model.User;

import java.util.Set;

public class CreateUserRequest {
    private String name;
    private String email;
    private String passwordHash;
    private Set<RoleEnum> role;

    public User toDomain() {
        return new User(name, email, passwordHash, role);
    }

    // Getters e Setters
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public void setPasswordHash(String passwordHash) { this.passwordHash = passwordHash; }

    public Set<RoleEnum> getRole() { return role; }
    public void setRole(Set<RoleEnum> role) { this.role = role; }
}
