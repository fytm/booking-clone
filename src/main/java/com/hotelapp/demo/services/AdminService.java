package com.hotelapp.demo.services;

import com.hotelapp.demo.dto.CreateAdminDto;
import com.hotelapp.demo.dto.UpdateAdminDto;
import com.hotelapp.demo.model.Admin;

import java.util.UUID;

public interface AdminService {
    Admin create(CreateAdminDto createAdminDto);

    Admin updateAdminDetails(UUID id, UpdateAdminDto updatedAdmin);

    void deleteAdminById(UUID id);
}
