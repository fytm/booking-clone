package com.hotelapp.demo.services;

import com.hotelapp.demo.dto.CreateRoomDto;
import com.hotelapp.demo.dto.UpdateRoomDto;
import com.hotelapp.demo.exceptions.RoomNotFoundException;
import com.hotelapp.demo.model.Room;
import com.hotelapp.demo.repository.RoomRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    RoomRepository roomRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public Room create(CreateRoomDto createRoomDTO) {
        return roomRepository.save(modelMapper.map(createRoomDTO, Room.class));
    }

    @Override
    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public Room getRoomById(UUID uuid) {
        return roomRepository.findById(uuid).orElseThrow(() -> new RoomNotFoundException(uuid));
    }

    @Override
    public Room updateRoom(UUID id, UpdateRoomDto updateRoomDto) {
        Room room = roomRepository.findById(id).orElseThrow(() -> new RoomNotFoundException(id));
        room.setNumber(updateRoomDto.getNumber());
        room.setCapacity(updateRoomDto.getCapacity());
        room.setStatus(updateRoomDto.getStatus());
        return roomRepository.save(room);
    }

    @Override
    public void deleteRoomById(UUID id) {
        roomRepository.deleteById(id);
    }

}
