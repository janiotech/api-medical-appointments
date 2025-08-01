package tech.janio.medical_appointments.infrastructure.mappers;

import org.springframework.stereotype.Component;
import tech.janio.medical_appointments.domain.model.User;
import tech.janio.medical_appointments.application.dto.user.UserResponse;
import tech.janio.medical_appointments.infrastructure.entity.UserEntity;

@Component
public class UserMapper {
    public static UserResponse toDomain(UserEntity entity) {
        User user = new User(entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getPassword(),
                entity.getRoles(),
                entity.getCreatedAt(),
                entity.getUpdatedAt());
        return UserResponse.fromDomain(user);
    }
}
