package com.example.edziennikbackend.dtos;

import com.example.edziennikbackend.model.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {
    private String login;

    public UserDTO(User user) {
        this.login = user.getLogin();
    }
}
