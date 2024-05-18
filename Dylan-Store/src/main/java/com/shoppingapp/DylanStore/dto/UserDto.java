package com.shoppingapp.DylanStore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long userId;
    private String fullName;
    private String address;
    private String phone;
    private String email;
    private String password;
    private String position;
    private boolean isAdmin;
    private Date joinDate;


}
