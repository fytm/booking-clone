package com.hotelapp.demo.dto;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CreateAdminDto {
    private String firstname;
    private String lastname;
    private String username;
    private String password;
}
