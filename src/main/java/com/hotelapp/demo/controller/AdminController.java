package com.hotelapp.demo.controller;

import com.hotelapp.demo.dto.CreateAdminDto;
import com.hotelapp.demo.dto.UpdateAdminDto;
import com.hotelapp.demo.model.Admin;
import com.hotelapp.demo.services.AdminService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

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

    @Operation(summary = "Delete admin by id")
    @ApiResponse(description = "Delete request successful")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<?> deleteAdmin(@PathVariable UUID id) {
        adminService.deleteAdminById(id);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @Operation(summary = "Update admin details")
    @ApiResponse(description = "Details updated successfully")
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Admin> updateAdmin(@PathVariable UUID id, @RequestBody UpdateAdminDto updateAdminDto) {
        return new ResponseEntity<>(adminService.updateAdminDetails(id, updateAdminDto), HttpStatus.ACCEPTED);
    }
}
