package com.shoppingapp.DylanStore.controller;

import com.shoppingapp.DylanStore.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<Map<String,Object>> login(@RequestBody LoginRequest loginRequest){
        if (userService.authenticate(loginRequest.getEmail(), loginRequest.getPassword()) != null){
            String token = generateToken(loginRequest.getEmail());
            Map<String,Object> response = new HashMap<>();
            response.put("token",token);
            return ResponseEntity.ok(response);
        }else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
        }
    }
    private String generateToken(String email) {
        return "user_" + email;
    }

}
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
class LoginRequest {
    private String email;
    private String password;
}