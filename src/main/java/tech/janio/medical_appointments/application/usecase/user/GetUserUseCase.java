package tech.janio.medical_appointments.application.usecase.user;

import tech.janio.medical_appointments.domain.exceptions.DomainException;
import tech.janio.medical_appointments.domain.model.User;
import tech.janio.medical_appointments.domain.repository.UserRepository;

import java.util.UUID;

public class GetUserUseCase {
    private final UserRepository userRepository;

    public GetUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(UUID userId){
        User user = this.userRepository.findById(userId).orElse(null);
        if(user == null) {
            throw new DomainException(404 ,"User not found");
        }
        return user;
    }
}
