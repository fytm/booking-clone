package com.hotelapp.demo.services;

import com.hotelapp.demo.dto.CreateAdminDto;
import com.hotelapp.demo.dto.UpdateAdminDto;
import com.hotelapp.demo.exceptions.AdminNotFoundException;
import com.hotelapp.demo.model.Admin;
import com.hotelapp.demo.repository.AdminRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminRepository adminRepository;
    @Autowired
    ModelMapper mapper;
    @Override
    public Admin create(CreateAdminDto createAdminDto) {
        return adminRepository.save(mapper.map(createAdminDto, Admin.class));
    }

    @Override
    public Admin updateAdminDetails(UUID id, UpdateAdminDto updatedAdmin) {
        Admin admin  = adminRepository.findById(id).orElseThrow(()-> new AdminNotFoundException(id)) ;
        admin.setFirstname(updatedAdmin.getFirstname());
        admin.setLastname(updatedAdmin.getLastname());
        admin.setPassword(updatedAdmin.getPassword());
        return adminRepository.save(admin);
    }

    @Override
    public void deleteAdminById(UUID id) {
        try{
            adminRepository.deleteById(id);
        }catch (EmptyResultDataAccessException e){
            throw new AdminNotFoundException(id);
        }
    }
}
