package com.hotelapp.demo.services;

import com.hotelapp.demo.dto.CreateHotelDto;
import com.hotelapp.demo.model.Hotel;

public interface HotelService {
    Hotel create(CreateHotelDto createHotelDto);
}
