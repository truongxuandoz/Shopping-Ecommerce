package com.shoppingapp.DylanStore.mapper;

import com.shoppingapp.DylanStore.dto.UserDto;
import com.shoppingapp.DylanStore.entity.User;

public class UserMapper {
    public static UserDto mapToUserDto (User user){
        return new UserDto(
                user.getUserId(),
                user.getFullName(),
                user.getAddress(),
                user.getPhone(),
                user.getEmail(),
                user.getPassword(),
                user.getPosition(),
                user.getRole(),
                user.getJoinDate()
        );
    }
    public static User maptoUser(UserDto userDto){
        return new User(
                userDto.getUserId(),
                userDto.getAddress(),
                userDto.getFullName(),
                userDto.getEmail(),
                userDto.getPhone(),
                userDto.getPassword(),
                userDto.getPosition(),
                userDto.getRole(),
                userDto.getJoinDate()
        );
    }
}


