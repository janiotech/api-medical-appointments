package tech.janio.medical_appointments.infrastructure.repository.user;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;
import tech.janio.medical_appointments.domain.model.User;
import tech.janio.medical_appointments.domain.repository.UserRepository;
import tech.janio.medical_appointments.application.dto.user.UserResponse;
import tech.janio.medical_appointments.infrastructure.entity.UserEntity;
import tech.janio.medical_appointments.infrastructure.mappers.UserMapper;

import java.util.*;
import java.util.stream.Collectors;

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

    @Override
    public List<UserResponse> findAllPaginated(int page, int size) {
        return jpaRepository.findAll(PageRequest.of(page, size))
                .stream()
                .map(UserMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public long countAll() {
        return jpaRepository.count();
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
