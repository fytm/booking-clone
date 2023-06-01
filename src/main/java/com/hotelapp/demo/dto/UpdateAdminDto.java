package com.hotelapp.demo.dto;

import lombok.*;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAdminDto {

    private String firstName;
    private String lastName;
    private String password;
}
