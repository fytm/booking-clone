package com.hotelapp.demo.dto;

import com.hotelapp.demo.model.Room;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ViewHotelDto {
    private String name;
    private String address;
    private String contact;
    private Timestamp created;
    private List<Room> rooms;

}
