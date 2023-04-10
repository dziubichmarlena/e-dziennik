package com.example.edziennikbackend.controller;

import com.example.edziennikbackend.config.UserAuthenticationProvider;
import com.example.edziennikbackend.dtos.LoginResponseDTO;
import com.example.edziennikbackend.model.User;
import com.example.edziennikbackend.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    UserAuthenticationProvider userAuthenticationProvider;
    UserService userService;

    public AuthController(UserAuthenticationProvider userAuthenticationProvider, UserService userService) {
        this.userAuthenticationProvider = userAuthenticationProvider;
        this.userService = userService;
    }

    @PostMapping("login")
    public ResponseEntity<LoginResponseDTO> login(@AuthenticationPrincipal User user) {
        LoginResponseDTO responseDTO = new LoginResponseDTO();
        responseDTO.setToken(userAuthenticationProvider.createToken(user));
        return ok(responseDTO);
    }

    @PostMapping("changePassword")
    public void changePassword(@RequestBody User user){
        User updatedUser = userService.findUserByLogin(user.getLogin());
        updatedUser.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
        userService.updateUser(updatedUser);
    }
}
