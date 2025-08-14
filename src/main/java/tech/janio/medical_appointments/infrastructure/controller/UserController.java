package tech.janio.medical_appointments.infrastructure.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.janio.medical_appointments.application.usecase.user.CreateUserUseCase;
import tech.janio.medical_appointments.application.usecase.user.GetUserUseCase;
import tech.janio.medical_appointments.application.usecase.user.GetUsersPaginatedUseCase;
import tech.janio.medical_appointments.domain.model.User;
import tech.janio.medical_appointments.application.dto.user.UserRequest;
import tech.janio.medical_appointments.application.dto.user.UserResponse;

import java.net.URI;
import java.util.UUID;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final CreateUserUseCase createUserUseCase;
    private final GetUserUseCase getUserUseCase;
    private final GetUsersPaginatedUseCase getUsersPaginatedUseCase;

    public UserController(CreateUserUseCase createUserUseCase, GetUserUseCase getUserUseCase, GetUsersPaginatedUseCase getUsersPaginatedUseCase) {
        this.createUserUseCase = createUserUseCase;
        this.getUserUseCase = getUserUseCase;
        this.getUsersPaginatedUseCase = getUsersPaginatedUseCase;
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody UserRequest request) {
        User user = createUserUseCase.execute(request.toDomain());
        UserResponse response = UserResponse.fromDomain(user);

        return ResponseEntity
                .created(URI.create("/api/users/" + user.getId()))
                .body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable UUID id) {
        User user = getUserUseCase.execute(id);
        UserResponse response = UserResponse.fromDomain(user);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public Object PaginatedResponsegetAll(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        return getUsersPaginatedUseCase.execute(page, size);
    }
}
