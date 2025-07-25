//package tech.janio.medical_appointments.infrastructure.repository.appointment;
//
//import org.springframework.stereotype.Repository;
//import tech.janio.medical_appointments.domain.model.Appointment;
//import tech.janio.medical_appointments.domain.model.Doctor;
//import tech.janio.medical_appointments.domain.model.Patient;
//import tech.janio.medical_appointments.domain.model.User;
//import tech.janio.medical_appointments.domain.repository.AppointmentRepository;
//import tech.janio.medical_appointments.infrastructure.entity.AppointmentEntity;
//import tech.janio.medical_appointments.infrastructure.entity.DoctorEntity;
//import tech.janio.medical_appointments.infrastructure.entity.PatientEntity;
//import tech.janio.medical_appointments.infrastructure.entity.UserEntity;
//
//import java.time.OffsetDateTime;
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//
//@Repository
//public class AppointmentRepositoryImpl implements AppointmentRepository {
//
//    private final AppointmentJpaRepository appointmentJpaRepository;
//
//    public AppointmentRepositoryImpl(AppointmentJpaRepository appointmentJpaRepository) {
//        this.appointmentJpaRepository = appointmentJpaRepository;
//    }
//
//    @Override
//    public Appointment save(Appointment appointment) {
//        AppointmentEntity entity = toEntity(appointment);
//        AppointmentEntity saved = appointmentJpaRepository.save(entity);
//        return toDomain(saved);
//    }
//
//    @Override
//    public Optional<Appointment> findById(UUID id) {
//        return appointmentJpaRepository.findById(id).map(this::toDomain);
//    }
//
//    @Override
//    public List<Appointment> findByDoctorId(UUID doctorId) {
//        return List.of();
//    }
//
//    @Override
//    public List<Appointment> findByPatientId(UUID patientId) {
//        return List.of();
//    }
//
//    @Override
//    public boolean existsByDoctorIdAndDateTime(UUID doctorId, OffsetDateTime dateTime) {
//        return false;
//    }
//
//    private AppointmentEntity toEntity(Appointment appointment) {
//        User userPatient = appointment.getPatient().getUser();
//        PatientEntity patientEntity = new PatientEntity(
//                appointment.getPatient().getId(),
//                new UserEntity(
//                        userPatient.getId(),
//                        userPatient.getName(),
//                        userPatient.getEmail(),
//                        userPatient.getPasswordHash(),
//                        userPatient.getRoles(),
//                        userPatient.getCreatedAt(),
//                        userPatient.getUpdatedAt()
//                )
//        );
//
//        // User → Doctor
//        User userDoctor = appointment.getDoctor().getUser();
//        DoctorEntity doctorEntity = new DoctorEntity(
//                appointment.getDoctor().getId(),
//                new UserEntity(
//                        userDoctor.getId(),
//                        userDoctor.getName(),
//                        userDoctor.getEmail(),
//                        userDoctor.getPasswordHash(),
//                        userDoctor.getRoles(),
//                        userDoctor.getCreatedAt(),
//                        userDoctor.getUpdatedAt()
//                ),
//                appointment.getDoctor().getSpecialty()
//        );
//
//        return new AppointmentEntity(
//                appointment.getId(),
//                patientEntity,
//                doctorEntity,
//                appointment.getDateTime()
//        );
//    }
//
//    private Appointment toDomain(AppointmentEntity entity) {
//        User doctorUser = new User(
//                entity.getDoctor().getUser().getName(),
//                entity.getDoctor().getUser().getEmail(),
//                entity.getDoctor().getUser().getPassword(),
//                entity.getDoctor().getUser().getRoles()
//        );
//
//        Doctor doctor = new Doctor(doctorUser, entity.getDoctor().getSpecialty());
//
//        User patientUser = new User(
//                entity.getPatient().getUser().getName(),
//                entity.getPatient().getUser().getEmail(),
//                entity.getPatient().getUser().getPassword(),
//                entity.getPatient().getUser().getRoles()
//        );
//
//        Patient patient = new Patient(patientUser);
//
//        return new Appointment(
//                doctor,
//                patient,
//                entity.getStartTime()
//        );
//    }
//}
