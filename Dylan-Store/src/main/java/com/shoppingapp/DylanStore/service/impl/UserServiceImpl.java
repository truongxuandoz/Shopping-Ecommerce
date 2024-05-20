package com.shoppingapp.DylanStore.service.impl;

import com.shoppingapp.DylanStore.dto.UserDto;
import com.shoppingapp.DylanStore.entity.User;
import com.shoppingapp.DylanStore.mapper.UserMapper;
import com.shoppingapp.DylanStore.repository.UserRepository;
import com.shoppingapp.DylanStore.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDto createUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto authenticate(String email, String password) {
        User user = userRepository.findByEmail(email);
            if (user != null && user.getPassword().equals(password)){
                return UserMapper.mapToUserDto(user);

        }
        return null;
    }
}
