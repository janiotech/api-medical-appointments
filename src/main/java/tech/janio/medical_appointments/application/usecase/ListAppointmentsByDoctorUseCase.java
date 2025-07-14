package tech.janio.medical_appointments.application.usecase;

import tech.janio.medical_appointments.domain.model.Appointment;
import tech.janio.medical_appointments.domain.model.Doctor;
import tech.janio.medical_appointments.domain.repository.AppointmentRepository;
import tech.janio.medical_appointments.domain.repository.DoctorRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ListAppointmentsByDoctorUseCase {

    private final DoctorRepository doctorRepository;
    private final AppointmentRepository appointmentRepository;

    public ListAppointmentsByDoctorUseCase(
            DoctorRepository doctorRepository,
            AppointmentRepository appointmentRepository) {
        this.doctorRepository = doctorRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> execute(UUID doctorUserId) {
        Optional<Doctor> optionalDoctor = doctorRepository.findByUserId(doctorUserId);

        if (optionalDoctor.isEmpty()) {
            throw new IllegalArgumentException("Doctor not found.");
        }

        Doctor doctor = optionalDoctor.get();
        return Collections.unmodifiableList(
                appointmentRepository.findByDoctorId(doctor.getId())
        );
    }
}