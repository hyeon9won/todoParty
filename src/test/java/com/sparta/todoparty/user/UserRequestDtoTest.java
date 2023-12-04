package com.sparta.todoparty.user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.sparta.todoparty.CommonTest.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("유저 요청 DTO 생성")
class UserRequestDtoTest {

    @DisplayName("유저 요청 DTO 생성 성공")
    @Test
    void userRequestDtoTest() {
        // Given
        UserRequestDto userRequestDto = new UserRequestDto();
        userRequestDto.setUsername(TEST_USER_NAME);
        userRequestDto.setPassword(TEST_USER_PASSWORD);

        // When
        String usernamePattern = "^[a-z0-9]{4,10}$";
        String passwordPattern = "^[a-zA-Z0-9]{8,15}$";

        // Then
        assertTrue(userRequestDto.getUsername().matches(usernamePattern));
        assertTrue(userRequestDto.getPassword().matches(passwordPattern));
    }

    @DisplayName("유저 요청 DTO 생성 실패 - 잘못된 username")
    @Test
    void usernameTest() {
        // Given
        UserRequestDto userRequestDto = new UserRequestDto();

        userRequestDto.setUsername("Invaild username"); // username이 잘못되었을 때
        userRequestDto.setPassword(TEST_USER_PASSWORD);

        // When
        String usernamePattern = "^[a-z0-9]{4,10}$";
        String passwordPattern = "^[a-zA-Z0-9]{8,15}$";

        // Then
        assertFalse(userRequestDto.getUsername().matches(usernamePattern), "잘못된 양식의 사용자명 입력");
        assertTrue(userRequestDto.getPassword().matches(passwordPattern), "잘못된 비밀번호 입력");
    }

    @DisplayName("유저 요청 DTO 생성 실패 - 잘못된 password")
    @Test
    void passwordTest() {
        // Given
        UserRequestDto userRequestDto = new UserRequestDto();

        userRequestDto.setUsername(TEST_USER_NAME);
        userRequestDto.setPassword("Invaild password"); // password가 잘못되었을 때

        // When
        String usernamePattern = "^[a-z0-9]{4,10}$";
        String passwordPattern = "^[a-zA-Z0-9]{8,15}$";

        // Then
        assertTrue(userRequestDto.getUsername().matches(usernamePattern), "잘못된 사용자명 입력");
        assertFalse(userRequestDto.getPassword().matches(passwordPattern), "잘못된 양식의 비밀번호 입력");
    }
}