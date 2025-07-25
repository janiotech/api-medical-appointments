//package tech.janio.medical_appointments.infrastructure.repository.patient;
//
//import org.springframework.stereotype.Repository;
//import tech.janio.medical_appointments.domain.model.Patient;
//import tech.janio.medical_appointments.domain.model.User;
//import tech.janio.medical_appointments.domain.repository.PatientRepository;
//import tech.janio.medical_appointments.infrastructure.entity.PatientEntity;
//import tech.janio.medical_appointments.infrastructure.entity.UserEntity;
//
//import java.util.Optional;
//import java.util.UUID;
//
//@Repository
//public class PatientRepositoryImpl implements PatientRepository {
//
//    private final PatientJpaRepository patientJpaRepository;
//
//    public PatientRepositoryImpl(PatientJpaRepository patientJpaRepository) {
//        this.patientJpaRepository = patientJpaRepository;
//    }
//
//    @Override
//    public Patient save(Patient patient) {
//        PatientEntity entity = toEntity(patient);
//        PatientEntity saved = patientJpaRepository.save(entity);
//        return toDomain(saved);
//    }
//
//    @Override
//    public Optional<Patient> findById(UUID id) {
//        return patientJpaRepository.findById(id).map(this::toDomain);
//    }
//
//    @Override
//    public Optional<Patient> findByUserId(UUID userId) {
//        return Optional.empty();
//    }
//
//    private PatientEntity toEntity(Patient patient) {
//        UserEntity userEntity = new UserEntity(
//                patient.getUser().getId(),
//                patient.getUser().getName(),
//                patient.getUser().getEmail(),
//                patient.getUser().getPasswordHash(),
//                patient.getUser().getRoles(),
//                patient.getUser().getCreatedAt(),
//                patient.getUser().getUpdatedAt()
//        );
//
//        return new PatientEntity(patient.getId(), userEntity);
//    }
//
//    private Patient toDomain(PatientEntity entity) {
//        User user = new User(
//                entity.getUser().getName(),
//                entity.getUser().getEmail(),
//                entity.getUser().getPassword(),
//                entity.getUser().getRoles()
//        );
//
//        return new Patient(user);
//    }
//}
