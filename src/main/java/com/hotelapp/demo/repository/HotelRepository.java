package com.hotelapp.demo.repository;

import com.hotelapp.demo.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface HotelRepository extends JpaRepository<Hotel, UUID> {
}
