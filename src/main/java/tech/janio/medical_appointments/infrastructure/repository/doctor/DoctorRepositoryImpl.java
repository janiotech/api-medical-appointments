//package tech.janio.medical_appointments.infrastructure.repository.doctor;
//
//import org.springframework.stereotype.Repository;
//import tech.janio.medical_appointments.domain.model.AvailableSlot;
//import tech.janio.medical_appointments.domain.model.Doctor;
//import tech.janio.medical_appointments.domain.model.User;
//import tech.janio.medical_appointments.domain.repository.DoctorRepository;
//import tech.janio.medical_appointments.infrastructure.entity.AvailableSlotEntity;
//import tech.janio.medical_appointments.infrastructure.entity.DoctorEntity;
//import tech.janio.medical_appointments.infrastructure.entity.UserEntity;
//import tech.janio.medical_appointments.infrastructure.repository.doctor.DoctorJpaRepository;
//import tech.janio.medical_appointments.infrastructure.repository.user.UserJpaRepository;
//
//import java.util.List;
//import java.util.Optional;
//import java.util.UUID;
//import java.util.stream.Collectors;
//
//@Repository
//public class DoctorRepositoryImpl implements DoctorRepository {
//
//    private final DoctorJpaRepository doctorJpaRepository;
//    private final UserJpaRepository userJpaRepository;
//
//    public DoctorRepositoryImpl(
//            DoctorJpaRepository doctorJpaRepository,
//            UserJpaRepository userJpaRepository
//    ) {
//        this.doctorJpaRepository = doctorJpaRepository;
//        this.userJpaRepository = userJpaRepository;
//    }
//
//    @Override
//    public Doctor save(Doctor doctor) {
//        DoctorEntity entity = toEntity(doctor);
//        return toDomain(doctorJpaRepository.save(entity));
//    }
//
//    @Override
//    public Optional<Doctor> findById(UUID id) {
//        return doctorJpaRepository.findById(id).map(this::toDomain);
//    }
//
//    @Override
//    public Optional<Doctor> findByUserId(UUID userId) {
//        return doctorJpaRepository.findByUserId(userId).map(this::toDomain);
//    }
//
//    // Mapping
//
//    private DoctorEntity toEntity(Doctor doctor) {
//        DoctorEntity entity = new DoctorEntity();
//        entity.setId(doctor.getId());
//
//        UserEntity userEntity = userJpaRepository.findById(doctor.getUser().getId())
//                .orElseThrow(() -> new IllegalArgumentException("User not found"));
//
//        entity.setUser(userEntity);
//
//        List<AvailableSlotEntity> slotEntities = doctor.getAvailableSlots().stream().map(slot -> {
//            AvailableSlotEntity slotEntity = new AvailableSlotEntity();
//            slotEntity.setId(slot.getId());
//            slotEntity.setDateTime(slot.getDateTime());
//            return slotEntity;
//        }).collect(Collectors.toList());
//
//        entity.setSpecialty(doctor.getSpecialty());
//
//        entity.setAvailableSlots(slotEntities);
//        return entity;
//    }
//
//    private Doctor toDomain(DoctorEntity entity) {
//        User user = new User(
//                entity.getUser().getName(),
//                entity.getUser().getEmail(),
//                entity.getUser().getPassword(),
//                entity.getUser().getRoles()
//        );
//
//        List<AvailableSlot> slots = entity.getAvailableSlots().stream().map(slot ->
//                new AvailableSlot(slot.getDateTime())
//        ).collect(Collectors.toList());
//
//        return new Doctor(user, entity.getSpecialty());
//    }
//}
