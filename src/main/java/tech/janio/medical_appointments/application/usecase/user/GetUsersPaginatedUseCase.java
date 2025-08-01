package tech.janio.medical_appointments.application.usecase.user;

import tech.janio.medical_appointments.application.dto.user.UserResponse;
import tech.janio.medical_appointments.domain.repository.UserRepository;

import java.util.List;

public class GetUsersPaginatedUseCase {
    private final UserRepository userRepository;

    public GetUsersPaginatedUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public PaginatedResponse execute(int page, int size) {
        List<UserResponse> users = userRepository.findAllPaginated(page, size);
        long total = userRepository.countAll();
        return new PaginatedResponse(users, total, page, size);
    }

    public static class PaginatedResponse {
        public final List<UserResponse> users;
        public final long total;
        public final int page;
        public final int size;

        public PaginatedResponse(List<UserResponse> users, long total, int page, int size) {
            this.users = users;
            this.total = total;
            this.page = page;
            this.size = size;
        }
    }
}
