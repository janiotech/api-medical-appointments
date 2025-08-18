package tech.janio.medical_appointments.domain.exceptions;

public class DuplicateEmailException extends RuntimeException {
    private final Integer code;

    public DuplicateEmailException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
