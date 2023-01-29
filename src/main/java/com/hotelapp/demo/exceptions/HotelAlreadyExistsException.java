package com.hotelapp.demo.exceptions;

public class HotelAlreadyExistsException extends RuntimeException {
    public HotelAlreadyExistsException(String name){
        super("Hotel name already taken");
    }
}
