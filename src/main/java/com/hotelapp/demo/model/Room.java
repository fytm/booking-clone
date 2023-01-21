package com.hotelapp.demo.model;

import com.hotelapp.demo.enums.RoomStatus;
import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
//@AllArgsConstructor
//@NoArgsConstructor
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID roomId;
    @Nonnull
    @Column(name = "number", nullable = false)
    String number;
    @Nonnull
    @Column(name = "floor", nullable = false)
    int floor;
    @Nonnull
    @Column(name = "capacity", nullable = false)
    int capacity;
    @Nonnull
    @Column(name = "status", nullable = false)
    RoomStatus status;
    @Nonnull
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hotel_id", nullable = false)
    Hotel hotel;

}
