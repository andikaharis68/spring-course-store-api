package com.enigma.api.inventory.exceptions;

import org.springframework.http.HttpStatus;

public class PathNotFoundException extends AplicationException {

    public PathNotFoundException() {
        super(HttpStatus.NOT_FOUND, "error." + HttpStatus.NOT_FOUND.value() + ".path");
    }
}