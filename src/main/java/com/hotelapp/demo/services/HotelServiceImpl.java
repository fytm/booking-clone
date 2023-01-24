package com.hotelapp.demo.services;

import com.hotelapp.demo.dto.CreateHotelDto;
import com.hotelapp.demo.dto.ViewHotelDto;
import com.hotelapp.demo.exceptions.HotelNotFoundException;
import com.hotelapp.demo.model.Hotel;
import com.hotelapp.demo.repository.HotelRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Autowired
    private ModelMapper modelMapper;
    public Hotel create(CreateHotelDto createHotelDto){
        return hotelRepository.save(modelMapper.map(createHotelDto,Hotel.class));
    }

    public List<Hotel> getAllHotels(){
        return hotelRepository.findAll();
    }

    public Hotel getHotelById(UUID id){
        return hotelRepository.findById(id).orElseThrow(() -> new HotelNotFoundException(id));
    }

    public Hotel updateHotel(Hotel updatedHotel){
        Hotel hotel = hotelRepository.findById(updatedHotel.getId()).orElseThrow(() ->new HotelNotFoundException(updatedHotel.getId()));
        hotel.setName(updatedHotel.getName());
        hotel.setAddress(updatedHotel.getAddress());
        hotel.setContact(updatedHotel.getContact());
        return hotelRepository.save(hotel);
    }

    public void deleteHotelById(UUID id){
        hotelRepository.deleteById(id);
    }
}
