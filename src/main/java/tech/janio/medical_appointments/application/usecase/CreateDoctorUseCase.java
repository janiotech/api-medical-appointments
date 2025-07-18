package tech.janio.medical_appointments.application.usecase;

import tech.janio.medical_appointments.domain.model.Doctor;
import tech.janio.medical_appointments.domain.repository.DoctorRepository;

public class CreateDoctorUseCase {
    private final DoctorRepository doctorRepository;

    public CreateDoctorUseCase(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public Doctor execute(Doctor doctor) {
        return doctorRepository.save(doctor);
    }
}
