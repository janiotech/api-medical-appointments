package tech.janio.medical_appointments.application.usecase;

import tech.janio.medical_appointments.domain.model.Appointment;
import tech.janio.medical_appointments.domain.model.AvailableSlot;
import tech.janio.medical_appointments.domain.model.Doctor;
import tech.janio.medical_appointments.domain.model.Patient;
import tech.janio.medical_appointments.domain.repository.AppointmentRepository;
import tech.janio.medical_appointments.domain.repository.DoctorRepository;
import tech.janio.medical_appointments.domain.repository.PatientRepository;

import java.time.OffsetDateTime;
import java.util.Optional;
import java.util.UUID;

public class ScheduleAppointmentUseCase {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    public ScheduleAppointmentUseCase(
            AppointmentRepository appointmentRepository,
            DoctorRepository doctorRepository,
            PatientRepository patientRepository) {
        this.appointmentRepository = appointmentRepository;
        this.doctorRepository = doctorRepository;
        this.patientRepository = patientRepository;
    }

    public void execute(UUID doctorUserId, UUID patientUserId, OffsetDateTime dateTime) {
        Optional<Doctor> optionalDoctor = doctorRepository.findByUserId(doctorUserId);
        Optional<Patient> optionalPatient = patientRepository.findByUserId(patientUserId);

        if (optionalDoctor.isEmpty()) {
            throw new IllegalArgumentException("Doctor not found.");
        }

        if (optionalPatient.isEmpty()) {
            throw new IllegalArgumentException("Patient not found.");
        }

        Doctor doctor = optionalDoctor.get();
        Patient patient = optionalPatient.get();

        boolean slotExists = doctor.getAvailableSlots().stream()
                .anyMatch(slot -> slot.getDateTime().isEqual(dateTime));

        if (!slotExists) {
            throw new IllegalArgumentException("This slot is not available.");
        }

        boolean conflict = appointmentRepository.existsByDoctorIdAndDateTime(doctor.getId(), dateTime);
        if (conflict) {
            throw new IllegalStateException("This slot is already booked.");
        }

        Appointment appointment = new Appointment(doctor, patient, dateTime);
        appointmentRepository.save(appointment);

        doctor.removeAvailableSlot(new AvailableSlot(dateTime));
        doctorRepository.save(doctor); // salva agenda atualizada
    }
}
