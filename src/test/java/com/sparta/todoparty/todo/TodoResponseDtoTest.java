package com.sparta.todoparty.todo;

import com.sparta.todoparty.user.User;
import com.sparta.todoparty.user.UserDto;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoResponseDtoTest {

    // 유효성 검사
    @Test
    public void Test() {
        // Given
        Todo todo = new Todo();
        todo.setTitle("제목 테스트");
        todo.setContent("내용 테스트");
        todo.setUser(new User());


        // When
        TodoResponseDto todoResponseDto = new TodoResponseDto(todo);

        // Then
        assertEquals(todo.getTitle(), todoResponseDto.getTitle());
        assertEquals(todo.getContent(), todoResponseDto.getContent());
        assertEquals(todo.getUser().getUsername(), todoResponseDto.getUser().getUsername());

    }
}

// 해결 못 함: ID, isCompleted, create date TEST