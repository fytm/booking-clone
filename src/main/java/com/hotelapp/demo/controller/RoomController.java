package com.hotelapp.demo.controller;

import com.hotelapp.demo.dto.CreateRoomDto;
import com.hotelapp.demo.dto.UpdateRoomDto;
import com.hotelapp.demo.model.Room;
import com.hotelapp.demo.services.RoomService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/manage/rooms")
@CrossOrigin(origins = "*")
public class RoomController {
    @Autowired
    RoomService roomService;

    @Operation(summary = "Create new room")
    @ApiResponse(description = "Room created successfully!")
    @PostMapping
    public ResponseEntity<?> createRoom(@RequestBody CreateRoomDto roomDTO) {
        return new ResponseEntity<>(roomService.create(roomDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Get all rooms in a particular hotel")
    @ApiResponse(description = "All rooms fetched successfully!")
    @GetMapping
    public ResponseEntity<List<Room>> getRooms() {
        return ResponseEntity.ok(roomService.getAllRooms());
    }

    @Operation(summary = "Get a room by id")
    @ApiResponse(description = "Room found!")
    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoom(@PathVariable UUID id) {
        return ResponseEntity.ok(roomService.getRoomById(id));
    }

    @Operation(summary = "Delete a room by id")
    @ApiResponse(description = "Room deleted successfully!")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteRoom(@PathVariable UUID id) {
        roomService.deleteRoomById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Update room details")
    @ApiResponse(description = "Room updated successfully!")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Room> updateRoom(@PathVariable UUID id, @RequestBody UpdateRoomDto updateRoomDto) {
        return new ResponseEntity<>(roomService.updateRoom(id, updateRoomDto), HttpStatus.ACCEPTED);
    }

}
