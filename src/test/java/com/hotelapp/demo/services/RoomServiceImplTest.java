package com.hotelapp.demo.services;

import com.hotelapp.demo.dto.CreateRoomDto;
import com.hotelapp.demo.exceptions.RoomNotFoundException;
import com.hotelapp.demo.model.Room;
import com.hotelapp.demo.repository.RoomRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
public class RoomServiceImplTest {
    @Autowired
    RoomService roomService;
    @MockBean
    RoomRepository mockRoomRepo;
    @MockBean
    ModelMapper mockModelMapper;

    @Test
    void createRoom() {
        //given a createRoomDto
        CreateRoomDto testDto = new CreateRoomDto();
        //when the create room method is called
        roomService.create(testDto);
        //then assert that the repository save function is called once
        verify(mockRoomRepo, times(1)).save(any());
        //and that the model mapper is called once
        verify(mockModelMapper, times(1)).map(testDto, Room.class);

    }

    @Test
    void getAllRooms() {
        roomService.getAllRooms();
        verify(mockRoomRepo, times(1)).findAll();
    }

    @Test
    void getRoomById() {
        //Mocked dependencies
        when(mockRoomRepo.findById(any())).thenReturn(Optional.of(new Room()));
        //given a room id
        UUID testId = UUID.randomUUID();
        //when the room service is called
        roomService.getRoomById(testId);
        //then verify that the repo is called with the id
        verify(mockRoomRepo, times(1)).findById(testId);
    }

    @Test
    void getRoomById_withInvalidId() throws RoomNotFoundException {
        //given a Room id not in the database
        UUID testId = UUID.randomUUID();
        //when the Room service is called
        //then verify that the repo is called and throws the exception
        Assertions.assertThrows(RoomNotFoundException.class, () -> roomService.getRoomById(testId));
        verify(mockRoomRepo, times(1)).findById(testId);
    }

    @Test
    void deleteRoom_withValidId() {
        when(mockRoomRepo.findById(any())).thenReturn(Optional.of(new Room()));
        //given a uuid to delete
        UUID testId = UUID.randomUUID();
        //when the request to delete the room is received
        roomService.deleteRoomById(testId);
        //then verify that the repo is called with the id
        verify(mockRoomRepo, times(1)).deleteById(testId);
    }
}
