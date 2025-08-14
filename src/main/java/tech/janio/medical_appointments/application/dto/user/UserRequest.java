package tech.janio.medical_appointments.application.dto.user;

import tech.janio.medical_appointments.domain.model.User;

public class UserRequest {
    private String name;
    private String email;
    private String password;

    public User toDomain() {
        return new User(name, email, password);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public void setPassword(String password) { this.password = password; }

}
