package tech.janio.medical_appointments.infrastructure.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import tech.janio.medical_appointments.application.usecase.CreateDoctorUseCase;
import tech.janio.medical_appointments.domain.repository.DoctorRepository;

@Configuration
public class DoctorUseCaseConfig {
    @Bean
    public CreateDoctorUseCase createDoctorUseCase(DoctorRepository doctorRepository) {
        return new CreateDoctorUseCase(doctorRepository);
    }
}