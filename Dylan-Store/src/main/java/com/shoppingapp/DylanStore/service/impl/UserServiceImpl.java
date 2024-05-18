package com.shoppingapp.DylanStore.service.impl;

import com.shoppingapp.DylanStore.dto.UserDto;
import com.shoppingapp.DylanStore.entity.User;
import com.shoppingapp.DylanStore.mapper.UserMapper;
import com.shoppingapp.DylanStore.repository.UserRepository;
import com.shoppingapp.DylanStore.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public UserDto createUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserDto authenticate(String email, String password) {
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (user != null && passwordEncoder.matches(password, user.getPassword())){
                return UserMapper.mapToUserDto(user);
            }
        }
        return null;
    }
}
