package tech.janio.medical_appointments.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.janio.medical_appointments.application.usecase.user.CreateUserUseCase;
import tech.janio.medical_appointments.application.usecase.user.GetUserUseCase;
import tech.janio.medical_appointments.application.usecase.user.GetUsersPaginatedUseCase;
import tech.janio.medical_appointments.domain.repository.UserRepository;

@Configuration
public class UserUseCaseConfig {
    @Bean
    public CreateUserUseCase createUserUseCase(UserRepository userRepository) {
        return new CreateUserUseCase(userRepository);
    }
    @Bean
    public GetUserUseCase getUserUseCase(UserRepository userRepository) {
        return new GetUserUseCase(userRepository);
    }

    @Bean
    public GetUsersPaginatedUseCase getUsersPaginatedUseCase(UserRepository userRepository){
        return new GetUsersPaginatedUseCase(userRepository);
    }
}
