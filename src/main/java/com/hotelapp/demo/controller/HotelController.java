package com.hotelapp.demo.controller;

import com.hotelapp.demo.dto.CreateHotelDto;
import com.hotelapp.demo.dto.UpdateHotelDto;
import com.hotelapp.demo.exceptions.HotelNotFoundException;
import com.hotelapp.demo.model.Hotel;
import com.hotelapp.demo.services.HotelServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/manage/hotels")
@CrossOrigin(origins = "*")
public class HotelController {
    @Autowired
    HotelServiceImpl hotelService;

    @Operation(summary = "Create new hotel")
    @ApiResponse(description = "Hotel created successfully!")
    @PostMapping
    public ResponseEntity<?> createHotel(@RequestBody CreateHotelDto hotelDto) {
        return new ResponseEntity<>(hotelService.create(hotelDto), HttpStatus.CREATED);
    }

    @Operation(summary = "Get all hotels")
    @ApiResponse(description = "All hotels fetched successfully!")
    @GetMapping
    public ResponseEntity<List<Hotel>> getHotels() {
        return ResponseEntity.ok(hotelService.getAllHotels());
    }

    @Operation(summary = "Get a hotel by id")
    @ApiResponse(description = "Hotel found!")
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getHotel(@PathVariable UUID id) {
        return ResponseEntity.ok(hotelService.getHotelById(id));
    }

    @Operation(summary = "Delete a hotel by id")
    @ApiResponse(description = "Hotel deleted successfully!")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteHotel(@PathVariable UUID id) {
        hotelService.deleteHotelById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Update a hotel's details")
    @ApiResponse(description = "Hotel updated successfully!")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Hotel> updateHotel(@PathVariable UUID id, @RequestBody UpdateHotelDto updateHotelDto) {
        return new ResponseEntity<>(hotelService.updateHotel(id, updateHotelDto), HttpStatus.ACCEPTED);
    }
}
