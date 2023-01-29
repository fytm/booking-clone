package com.hotelapp.demo.services;

import com.hotelapp.demo.dto.CreateHotelDto;
import com.hotelapp.demo.dto.UpdateHotelDto;
import com.hotelapp.demo.exceptions.HotelNotFoundException;
import com.hotelapp.demo.model.Hotel;

import java.util.List;
import java.util.UUID;

public interface HotelService {
    Hotel create(CreateHotelDto createHotelDto);

    List<Hotel> getAllHotels();

    Hotel getHotelById(UUID id) throws HotelNotFoundException;

    Hotel updateHotel(UUID id, UpdateHotelDto updatedHotel);

    void deleteHotelById(UUID id);
}
