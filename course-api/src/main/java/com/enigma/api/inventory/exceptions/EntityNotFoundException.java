package com.enigma.api.inventory.exceptions;
import org.springframework.http.HttpStatus;

public class EntityNotFoundException extends AplicationException {
    public EntityNotFoundException() {
        super(HttpStatus.NOT_FOUND, "error." + HttpStatus.NOT_FOUND.value() + ".entity");
    }
}