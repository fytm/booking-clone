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
    @Column(name = "first_name")
    private String firstName;
    @NonNull
    @Column(name = "last_name")
    private String lastName;
    @NonNull
    @Column(name = "username", nullable = false)
    private String username;
    @NonNull
    @Column(name= "password", nullable = false)
    private String password;
}
