package com.enigma.api.inventory.exceptions;
import org.springframework.http.HttpStatus;

public class AplicationException extends RuntimeException {
    private HttpStatus status;
    public AplicationException(HttpStatus status, String message) {
        super(message);
        this.status = status;
    }
    public HttpStatus getStatus() {
        return status;
    }
}
