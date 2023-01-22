package com.hotelapp.demo.service;

import com.hotelapp.demo.dto.CreateHotelDto;
import com.hotelapp.demo.model.Hotel;
import com.hotelapp.demo.repository.HotelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ModelMapper modelMapper;
    public void create(CreateHotelDto createHotelDto){
        hotelRepository.save(modelMapper.map(createHotelDto,Hotel.class));
    }
}
