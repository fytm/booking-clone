package com.hotelapp.demo.dto;

import com.hotelapp.demo.enums.RoomStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateRoomDto {
    String number;
    int floor;
    int capacity;
    RoomStatus status;
    @NonNull UUID hotelId;
}
