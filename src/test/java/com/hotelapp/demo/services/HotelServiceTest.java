package com.hotelapp.demo.services;

import com.hotelapp.demo.dto.CreateHotelDto;
import com.hotelapp.demo.model.Hotel;
import com.hotelapp.demo.repository.HotelRepository;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class HotelServiceTest {
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
}