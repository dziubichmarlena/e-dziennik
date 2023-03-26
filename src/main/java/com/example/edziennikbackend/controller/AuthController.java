package com.example.edziennikbackend.controller;

import com.example.edziennikbackend.config.UserAuthenticationProvider;
import com.example.edziennikbackend.dtos.LoginResponseDTO;
import com.example.edziennikbackend.model.Student;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.ResponseEntity.ok;

@RestController
public class AuthController {

    UserAuthenticationProvider userAuthenticationProvider;

    public AuthController(UserAuthenticationProvider userAuthenticationProvider) {
        this.userAuthenticationProvider = userAuthenticationProvider;
    }

    @PostMapping("login")
    public ResponseEntity<LoginResponseDTO> login(@AuthenticationPrincipal Student student) {
        LoginResponseDTO responseDTO = new LoginResponseDTO();
        responseDTO.setToken(userAuthenticationProvider.createToken(student));
        return ok(responseDTO);
    }
}
