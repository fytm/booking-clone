package com.hotelapp.demo.services;

import com.hotelapp.demo.dto.CreateRoomDTO;
import com.hotelapp.demo.dto.UpdateRoomDto;
import com.hotelapp.demo.model.Room;

import java.util.List;
import java.util.UUID;

public interface RoomService {

    Room create(CreateRoomDTO createRoomDTO);
    List<Room> getAllRooms();
    Room getRoomById(UUID uuid);

    Room updateRoom(UUID id, UpdateRoomDto updateRoomDto);

    void deleteRoomById(UUID id);

}
