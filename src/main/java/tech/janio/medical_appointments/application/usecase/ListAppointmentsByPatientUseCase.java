package tech.janio.medical_appointments.application.usecase;


import tech.janio.medical_appointments.domain.model.Appointment;
import tech.janio.medical_appointments.domain.model.Patient;
import tech.janio.medical_appointments.domain.repository.AppointmentRepository;
import tech.janio.medical_appointments.domain.repository.PatientRepository;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ListAppointmentsByPatientUseCase {

    private final PatientRepository patientRepository;
    private final AppointmentRepository appointmentRepository;

    public ListAppointmentsByPatientUseCase(
            PatientRepository patientRepository,
            AppointmentRepository appointmentRepository) {
        this.patientRepository = patientRepository;
        this.appointmentRepository = appointmentRepository;
    }

    public List<Appointment> execute(UUID patientUserId) {
        Optional<Patient> optionalPatient = patientRepository.findByUserId(patientUserId);

        if (optionalPatient.isEmpty()) {
            throw new IllegalArgumentException("Patient not found.");
        }

        Patient patient = optionalPatient.get();
        return Collections.unmodifiableList(
                appointmentRepository.findByPatientId(patient.getId())
        );
    }
}
