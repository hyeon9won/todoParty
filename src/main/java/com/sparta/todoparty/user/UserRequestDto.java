package com.sparta.todoparty.user;

import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.Pattern;

@Getter
@Setter
public class UserRequestDto {
    @Pattern(regexp = "^[a-z0-9]{4,10}$")
    private String username;

    @Pattern(regexp = "^[a-zA-Z0-9]{8,15}$")
    private String password;
}
