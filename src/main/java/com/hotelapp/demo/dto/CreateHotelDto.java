package com.hotelapp.demo.dto;

import jakarta.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateHotelDto {
    @Nonnull
    private String name;
    @Nonnull
    private String address;
    @Nonnull
    private String contact;
    private Timestamp created;
}
