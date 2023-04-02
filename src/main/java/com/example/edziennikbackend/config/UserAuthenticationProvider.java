package com.example.edziennikbackend.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.example.edziennikbackend.dtos.LoginRequestDTO;
import com.example.edziennikbackend.model.Student;
import com.example.edziennikbackend.service.StudentService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Collections;
import java.util.Date;

@Component
public class UserAuthenticationProvider {
    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKey;

    private final StudentService studentService;

    public UserAuthenticationProvider(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostConstruct
    protected void init() {
        // this is to avoid having the raw secret key available in the JVM
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(Student student) {
        Date now = new Date();
        Date validity = new Date(now.getTime() + 3600000); // 1 hour

        Algorithm algorithm = Algorithm.HMAC256(secretKey);
        return JWT.create()
                .withClaim("role", student.getRole())
                .withIssuer(student.getLogin())
                .withIssuedAt(now)
                .withExpiresAt(validity)
                .sign(algorithm);
    }

    public Authentication validateToken(String token) {
        Algorithm algorithm = Algorithm.HMAC256(secretKey);

        JWTVerifier verifier = JWT.require(algorithm)
                .build();

        DecodedJWT decoded = verifier.verify(token);

        Student student = studentService.findStudentByLogin(decoded.getIssuer());

        return new UsernamePasswordAuthenticationToken(student, null, Collections.emptyList());
    }

    public Authentication validateCredentials(LoginRequestDTO credentialsDto) {
        Student student = studentService.findStudentByLogin(credentialsDto.getLogin());
        if (student == null || !student.getPassword().equals(credentialsDto.getPassword())) {
            throw new RuntimeException("Invalid credentials");
        }

        return new UsernamePasswordAuthenticationToken(student, null, Collections.emptyList());
    }
}
