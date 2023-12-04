package com.sparta.todoparty.todo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TodoRequestDtoTest {

    // 유효성 검사
    @Test
    public void Test() {
        // Given
        TodoRequestDto todoRequestDto = new TodoRequestDto();
        todoRequestDto.setTitle("제목 테스트");
        todoRequestDto.setContent("내용 테스트");

        // When
        Todo todo = new Todo(todoRequestDto);

        // Then
        assertEquals(todoRequestDto.getTitle(), todo.getTitle());
        assertEquals(todoRequestDto.getContent(), todo.getContent());
    }
}