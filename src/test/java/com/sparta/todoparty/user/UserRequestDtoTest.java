package com.sparta.todoparty.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserRequestDtoTest {

    @Test
    void userRequestDtoTest() {
        // Given
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setUsername("testuser");
        userRequestDto.setPassword("Abcd1234");

        // When
        String usernamePattern = "^[a-z0-9]{4,10}$";
        String passwordPattern = "^[a-zA-Z0-9]{8,15}$";

        // Then
        assertTrue(userRequestDto.getUsername().matches(usernamePattern), "사용자명이 양식과 불일치");
        assertTrue(userRequestDto.getPassword().matches(passwordPattern), "비밀번호이 양식과 불일치");
    }

    @Test
    void usernameTest() {
        // Given
        UserRequestDto userRequestDto = new UserRequestDto();

        userRequestDto.setUsername("tst"); // username이 4글자 보다 적게 입력 됐을 때
        userRequestDto.setPassword("Abcd1234");

        // When
        String usernamePattern = "^[a-z0-9]{4,10}$";
        String passwordPattern = "^[a-zA-Z0-9]{8,15}$";

        // Then
        assertFalse(userRequestDto.getUsername().matches(usernamePattern), "잘못된 양식의 사용자명 입력");
        assertTrue(userRequestDto.getPassword().matches(passwordPattern), "잘못된 비밀번호 입력");
    }

    @Test
    void passwordTest() {
        // Given
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setUsername("testuser");

        userRequestDto.setPassword("Abc123"); // password가 8글자 보다 적게 입력 됐을 때

        // When
        String usernamePattern = "^[a-z0-9]{4,10}$";
        String passwordPattern = "^[a-zA-Z0-9]{8,15}$";

        // Then
        assertTrue(userRequestDto.getUsername().matches(usernamePattern), "잘못된 사용자명 입력");
        assertFalse(userRequestDto.getPassword().matches(passwordPattern), "잘못된 양식의 비밀번호 입력");
    }
}