package tech.janio.medical_appointments.application.usecase.user;

import tech.janio.medical_appointments.domain.exceptions.DuplicateEmailException;
import tech.janio.medical_appointments.domain.model.User;
import tech.janio.medical_appointments.domain.repository.UserRepository;

public class CreateUserUseCase {
    private final UserRepository userRepository;

    public CreateUserUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User execute(User user) {
        if(userRepository.existsByEmail(user.getEmail())){
           throw new DuplicateEmailException(409, "Email already exists");
        }
        return this.userRepository.save(user);
    }
}