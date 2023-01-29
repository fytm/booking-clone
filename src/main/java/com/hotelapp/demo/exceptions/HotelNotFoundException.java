package com.hotelapp.demo.exceptions;

import java.util.UUID;

public class HotelNotFoundException extends RuntimeException{
    public HotelNotFoundException(UUID id){
        super("Could not find hotel with id: " + id);
    }
}
