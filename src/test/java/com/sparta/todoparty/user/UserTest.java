package com.sparta.todoparty.user;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    // Id 값이 제대로 부여되는지 확인
    @Test
    public void getIdTest() {

        // Given
        User user = new User("Jacop", "abcd1234");

        // When
        Long userId = user.getId();

        // Then
        assertNotEquals(0, userId);
    }
}