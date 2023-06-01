package com.hotelapp.demo.repository;

import com.hotelapp.demo.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AdminRepository extends JpaRepository<Admin, UUID> {
}
