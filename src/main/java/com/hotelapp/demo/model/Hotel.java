package com.hotelapp.demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
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
    @NonNull
    @Column(name = "name", nullable = false)
    private String name;
    @NonNull
    @Column(name = "address", nullable = false)
    private String address;
    @NonNull
    @Column(name = "contact", nullable = false)
    private String contact;
    @Column(name = "created", updatable = false)
    @CreationTimestamp
    private Timestamp created;
    @OneToMany(mappedBy = "hotel", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Room> rooms;

}
