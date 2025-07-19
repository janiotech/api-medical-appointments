package tech.janio.medical_appointments.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.janio.medical_appointments.application.usecase.CreateDoctorUseCase;
import tech.janio.medical_appointments.domain.model.Doctor;
import tech.janio.medical_appointments.infrastructure.dto.CreateDoctorRequest;
import tech.janio.medical_appointments.infrastructure.dto.DoctorResponse;

import java.net.URI;

@RestController
@RequestMapping("/api/doctors")
public class DoctorController {

    private final CreateDoctorUseCase createDoctorUseCase;

    public DoctorController(CreateDoctorUseCase createDoctorUseCase) {
        this.createDoctorUseCase = createDoctorUseCase;
    }

    @PostMapping
    public ResponseEntity<DoctorResponse> createDoctor(@RequestBody CreateDoctorRequest request) {
        Doctor doctor = createDoctorUseCase.execute(request.toDomain());
        System.out.println(doctor.getName());
        DoctorResponse response = DoctorResponse.fromDomain(doctor);

        return ResponseEntity
                .created(URI.create("/api/doctors/" + doctor.getId()))
                .body(response);
    }
}
