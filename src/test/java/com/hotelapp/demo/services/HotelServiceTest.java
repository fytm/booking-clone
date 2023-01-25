package com.hotelapp.demo.services;

import com.hotelapp.demo.dto.CreateHotelDto;
import com.hotelapp.demo.exceptions.HotelNotFoundException;
import com.hotelapp.demo.model.Hotel;
import com.hotelapp.demo.repository.HotelRepository;
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
class HotelServiceImplTest {
    @Autowired
    HotelServiceImpl hotelService;
    @MockBean
    HotelRepository mockedHotelRepo;
    @MockBean
    ModelMapper mockedModelMapper;

    @Test
    void create() {
        //given a createHotelDto
        CreateHotelDto testDto = new CreateHotelDto();
        //when the create hotel method is called
        hotelService.create(testDto);
        //then assert that the repository save function is called once
        verify(mockedHotelRepo, times(1)).save(any());
        //and that the model mapper is called once
        verify(mockedModelMapper, times(1)).map(testDto, Hotel.class);
    }

    @Test
    void getAllHotels(){
        hotelService.getAllHotels();
        verify(mockedHotelRepo, times(1)).findAll();
    }
    @Test
    void getHotelById() {
        //Mocked dependencies
//        Mockito.mock(HotelRepository.class).findById(any());
        when(mockedHotelRepo.findById(any())).thenReturn(Optional.of(new Hotel()));
        //given a hotel id
        UUID testId = UUID.randomUUID();
        //when the hotel service is called
        hotelService.getHotelById(testId);
        //then verify that the repo is called with the id
        verify(mockedHotelRepo, times(1)).findById(testId);
    }
    @Test
    void getHotelById_withInvalidId() throws HotelNotFoundException{
        //given a hotel id
        UUID testId = UUID.randomUUID();
        //when the hotel service is called
        try{
            hotelService.getHotelById(testId);
        }catch (HotelNotFoundException e){
            System.out.println(e.getMessage());
        }
        //then verify that the repo is called with the id
        verify(mockedHotelRepo, times(1)).findById(testId);
    }

    @Test
    void deleteHotel_withValidId(){
        when(mockedHotelRepo.findById(any())).thenReturn(Optional.of(new Hotel()));
        //given a uuid to delete
        UUID testId = UUID.randomUUID();
        //when the request to delete the user is received
        hotelService.deleteHotelById(testId);
        //then verify that the repo is called with the id
        verify(mockedHotelRepo, times(1)).deleteById(testId);    }
}