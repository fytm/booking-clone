package com.hotelapp.demo.services;

import com.hotelapp.demo.dto.CreateHotelDto;
import com.hotelapp.demo.dto.UpdateHotelDto;
import com.hotelapp.demo.exceptions.HotelNotFoundException;
import com.hotelapp.demo.model.Hotel;
import com.hotelapp.demo.repository.HotelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public Hotel create(CreateHotelDto createHotelDto) {
        return hotelRepository.save(modelMapper.map(createHotelDto, Hotel.class));
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(UUID id) throws HotelNotFoundException {
        return hotelRepository.findById(id).orElseThrow(() -> new HotelNotFoundException(id));
    }

    @Override
    public Hotel updateHotel(UUID id, UpdateHotelDto updatedHotel) {
        Hotel hotel = hotelRepository.findById(id).orElseThrow(() -> new HotelNotFoundException(id));
        hotel.setName(updatedHotel.getName());
        hotel.setAddress(updatedHotel.getAddress());
        hotel.setContact(updatedHotel.getContact());
        return hotelRepository.save(hotel);
    }

    @Override
    public void deleteHotelById(UUID id) {
        try {
            hotelRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new HotelNotFoundException(id);
        }
    }
}
