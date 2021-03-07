package com.bichon.bichonpaytx.dto;

import lombok.Data;

@Data
public class UserDto {
    private int id;
    private String pin;
    private String name;
    private String phone;
    private String birth;
    private String email;
    private int wallet_id;
    private String creation_date;
}
