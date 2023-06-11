package com.hotelapp.demo.dto;

import lombok.*;


@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAdminDto {

    private String firstname;
    private String lastname;
    private String password;
}
