package com.hotelapp.demo.model;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @Nonnull
    @Column(name = "name", nullable = false)
    private String name;
    @Nonnull
    @Column(name = "address", nullable = false)
    private String address;
    @Nonnull
    @Column(name = "contact", nullable = false)
    private String contact;
    @Column(name = "created", updatable = false)
    @CreationTimestamp
    private Timestamp created;
    @OneToMany(mappedBy = "hotel", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Room> rooms;

}
