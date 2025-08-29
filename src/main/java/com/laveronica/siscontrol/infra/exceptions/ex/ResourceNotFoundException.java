package com.laveronica.siscontrol.infra.exceptions.ex;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String message) {
        super(message);
    }
}
