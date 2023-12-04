package com.sparta.todoparty.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserDtoTest {

    @Test
    void userTest() {
        // Given
        User user = new User("testuser", "Abcd1234");

        // When
        UserDto userDto = new UserDto(user);

        // Then
        assertNotNull(userDto);
        assertEquals(user.getUsername(), userDto.getUsername());
    }
}