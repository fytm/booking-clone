package com.hotelapp.demo.service;

import com.hotelapp.demo.dto.CreateHotelDto;
import com.hotelapp.demo.repository.HotelRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@SpringBootTest
class HotelServiceTest {
    @Autowired
    HotelService hotelService;
    @MockBean
    HotelRepository mockedHotelRepo;

    @Test
    void create() {
        //given a create hotel dto
        CreateHotelDto testDto = new CreateHotelDto();
        //when the create hotel method is called
        hotelService.create(testDto);
        //then assert that the repository save function is called once
        verify(mockedHotelRepo, times(1)).save(any());
    }
}