package tech.janio.medical_appointments.application.usecase;


import tech.janio.medical_appointments.domain.model.AvailableSlot;
import tech.janio.medical_appointments.domain.model.Doctor;
import tech.janio.medical_appointments.domain.repository.DoctorRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ListAvailableSlotsByDoctorUseCase {

    private final DoctorRepository doctorRepository;

    public ListAvailableSlotsByDoctorUseCase(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<AvailableSlot> execute(UUID doctorUserId) {
        Optional<Doctor> optionalDoctor = doctorRepository.findByUserId(doctorUserId);

        if (optionalDoctor.isEmpty()) {
            throw new IllegalArgumentException("Doctor not found.");
        }

        Doctor doctor = optionalDoctor.get();
        return Collections.unmodifiableList(doctor.getAvailableSlots());
    }
}
