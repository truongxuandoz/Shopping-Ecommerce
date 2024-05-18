package com.shoppingapp.DylanStore.service;

import com.shoppingapp.DylanStore.dto.UserDto;
import com.shoppingapp.DylanStore.entity.User;

public interface UserService {
    UserDto createUser(UserDto userDto);
    UserDto authenticate(String email, String password);
}
