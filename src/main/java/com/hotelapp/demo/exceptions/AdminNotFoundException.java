package com.hotelapp.demo.exceptions;

import java.util.UUID;

public class AdminNotFoundException extends RuntimeException {
    public AdminNotFoundException(UUID id) {
        super("Could not find admin with id: " + id);
    }
}
