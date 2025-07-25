package tech.janio.medical_appointments.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.janio.medical_appointments.application.usecase.CreateUserUseCase;
import tech.janio.medical_appointments.application.usecase.GetUserUseCase;
import tech.janio.medical_appointments.domain.model.User;
import tech.janio.medical_appointments.infrastructure.dto.CreateUserRequest;
import tech.janio.medical_appointments.infrastructure.dto.UserResponse;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final GetUserUseCase getUserUseCase;

    public UserController(CreateUserUseCase createUserUseCase, GetUserUseCase getUserUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.getUserUseCase = getUserUseCase;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody CreateUserRequest request) {
        User user = createUserUseCase.execute(request.toDomain());
        UserResponse response = UserResponse.fromDomain(user);

        return ResponseEntity
                .created(URI.create("/api/users/" + user.getId()))
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable UUID id) {
        User user = getUserUseCase.execute(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        UserResponse response = UserResponse.fromDomain(user);
        return ResponseEntity.ok(response);
    }
}
