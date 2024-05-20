package com.shoppingapp.DylanStore.controller;

import com.shoppingapp.DylanStore.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@Controller
public class AuthController {
    private UserService userService;

    // @PostMapping("/login")
    // public ResponseEntity<Map<String,Object>> login(@RequestParam("your_email")String email,
    //                                                 @RequestParam("your_pass") String pass){
    //     if (userService.authenticate(email,pass) != null){
    //         String token = generateToken(email);
    //         Map<String,Object> response = new HashMap<>();
    //         response.put("token",token);
    //         return ResponseEntity.ok(response);
    //     }else {
    //         return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
    //     }
    // }
    // private String generateToken(String email) {
    //     return "user_" + email;
    // }

}

