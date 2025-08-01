package tech.janio.medical_appointments.application.usecase.user;

import tech.janio.medical_appointments.domain.model.User;
import tech.janio.medical_appointments.domain.repository.UserRepository;

import java.util.UUID;

public class GetUserUseCase {
    private final UserRepository userRepository;

    public GetUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(UUID userId){
        return this.userRepository.findById(userId).orElseThrow(IllegalArgumentException::new);
    }
}
