package tech.janio.medical_appointments.infrastructure.repository.user;

import org.springframework.stereotype.Repository;
import tech.janio.medical_appointments.domain.model.User;
import tech.janio.medical_appointments.domain.repository.UserRepository;
import tech.janio.medical_appointments.infrastructure.entity.UserEntity;
import java.util.*;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final UserJpaRepository jpaRepository;
    public UserRepositoryImpl(UserJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public User save(User user) {
        UserEntity entity = toEntity(user);
        return toDomain(jpaRepository.save(entity));
    }

    @Override
    public Optional<User> findById(UUID id) {
        return jpaRepository.findById(id).map(this::toDomain);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return jpaRepository.findByEmail(email).map(this::toDomain);
    }

    @Override
    public boolean existsByEmail(String email) {
        return jpaRepository.existsByEmail(email);
    }

    private UserEntity toEntity(User user) {
        UserEntity entity = new UserEntity();
        entity.setId(user.getId());
        entity.setName(user.getName());
        entity.setEmail(user.getEmail());
        entity.setPassword(user.getPasswordHash());
        entity.setRoles(user.getRoles());
        entity.setCreatedAt(user.getCreatedAt());
        entity.setUpdatedAt(user.getUpdatedAt());
        return entity;
    }

    private User toDomain(UserEntity entity) {
        return new User(
                entity.getId(),
            entity.getName(),
            entity.getEmail(),
            entity.getPassword(),
            entity.getRoles(),
            entity.getCreatedAt(),
            entity.getUpdatedAt()
        );
    }
}
