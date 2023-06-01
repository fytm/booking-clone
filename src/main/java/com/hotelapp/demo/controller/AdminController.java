package com.hotelapp.demo.controller;

import com.hotelapp.demo.dto.CreateAdminDto;
import com.hotelapp.demo.services.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/manage/admin")
@CrossOrigin(origins = "*")
public class AdminController {
    @Autowired
    AdminService adminService;

    @Operation(summary = "Add new admin")
    @ApiResponse(description = "Admin added successfully!")
    @PostMapping
    public ResponseEntity<?> addAdmin(@RequestBody CreateAdminDto adminDto) {
        return new ResponseEntity<>(adminService.create(adminDto), HttpStatus.CREATED);
    }
}
