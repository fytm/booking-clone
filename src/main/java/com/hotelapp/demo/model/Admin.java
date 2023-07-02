package com.hotelapp.demo.model;

import lombok.*;

import javax.persistence.*;
import java.util.UUID;

@Entity
@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NonNull
    @Column(name = "first_name", nullable = false)
    private String firstname;
    @NonNull
    @Column(name = "last_name", nullable = false)
    private String lastname;
    @NonNull
    @Column(name = "username", nullable = false)
    private String username;
    @NonNull
    @Column(name= "password", nullable = false)
    private String password;
}
