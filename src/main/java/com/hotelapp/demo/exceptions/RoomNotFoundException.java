
package com.hotelapp.demo.exceptions;

import java.util.UUID;

public class RoomNotFoundException extends RuntimeException{
    public RoomNotFoundException(UUID id){
        super("Could not find room with id: " + id);
    }
}
