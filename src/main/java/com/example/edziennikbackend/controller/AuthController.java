package com.example.edziennikbackend.controller;

import com.example.edziennikbackend.config.UserAuthenticationProvider;
import com.example.edziennikbackend.dtos.LoginResponseDTO;
import com.example.edziennikbackend.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthController {
    UserAuthenticationProvider userAuthenticationProvider;

    public AuthController(UserAuthenticationProvider userAuthenticationProvider) {
        this.userAuthenticationProvider = userAuthenticationProvider;
    }

    @PostMapping("login")
    public ResponseEntity<LoginResponseDTO> login(@AuthenticationPrincipal User user) {
        LoginResponseDTO responseDTO = new LoginResponseDTO();
        responseDTO.setToken(userAuthenticationProvider.createToken(user));
        return ok(responseDTO);
    }
}
