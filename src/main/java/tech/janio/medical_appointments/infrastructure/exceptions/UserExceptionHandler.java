package tech.janio.medical_appointments.infrastructure.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import tech.janio.medical_appointments.domain.exceptions.DuplicateEmailException;

@RestControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(DuplicateEmailException.class)
    public ResponseEntity<ErrorResponse> handleDuplicateEmail(DuplicateEmailException ex) {
        ErrorResponse error = new ErrorResponse(409, ex.getMessage());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    public static class ErrorResponse {
        public Integer code;
        public String message;

        public ErrorResponse(Integer code, String message) {
            this.code = code;
            this.message = message;
        }
    }
}
