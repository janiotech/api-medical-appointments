package tech.janio.medical_appointments.domain.exceptions;

public class DomainException extends RuntimeException {
    private final Integer code;

    public DomainException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
