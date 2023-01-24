package com.hotelapp.demo.controller;

import com.hotelapp.demo.dto.CreateHotelDto;
import com.hotelapp.demo.services.HotelServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/manage/hotels")
@CrossOrigin(origins = "*")
public class HotelController {
    @Autowired
    HotelServiceImpl hotelService;

    @Operation(summary = "Create new hotel")
    @ApiResponse(responseCode = "201", description = "Hotel created successfully")
    @PostMapping
    public ResponseEntity<?> createHotel(@RequestBody CreateHotelDto hotelDto) {
        return new ResponseEntity<>(hotelService.create(hotelDto), HttpStatus.CREATED);
    }


}
