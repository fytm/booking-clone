package com.hotelapp.demo.services;

import com.hotelapp.demo.dto.CreateHotelDto;
import com.hotelapp.demo.model.Hotel;
import com.hotelapp.demo.repository.HotelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ModelMapper modelMapper;
    public Hotel create(CreateHotelDto createHotelDto){
        return hotelRepository.save(modelMapper.map(createHotelDto,Hotel.class));
    }
}
