package tech.janio.medical_appointments.application.usecase;

import tech.janio.medical_appointments.domain.model.AvailableSlot;
import tech.janio.medical_appointments.domain.model.Doctor;
import tech.janio.medical_appointments.domain.repository.DoctorRepository;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

public class AddAvailableSlotUseCase {

    private final DoctorRepository doctorRepository;

    public AddAvailableSlotUseCase(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public void execute(UUID doctorUserId, OffsetDateTime dateTime) {
        Optional<Doctor> optionalDoctor = doctorRepository.findByUserId(doctorUserId);

        if (optionalDoctor.isEmpty()) {
            throw new IllegalArgumentException("Doctor not found.");
        }

        Doctor doctor = optionalDoctor.get();

        AvailableSlot newSlot = new AvailableSlot(dateTime);
        doctor.addAvailableSlot(newSlot);

        doctorRepository.save(doctor);
    }
}
