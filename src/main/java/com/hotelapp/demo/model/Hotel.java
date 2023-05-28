package com.hotelapp.demo.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.UUID;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
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

}
