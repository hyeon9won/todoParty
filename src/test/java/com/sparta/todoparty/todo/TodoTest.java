package com.sparta.todoparty.todo;

import com.sparta.todoparty.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Todo Entity 내 메서드 별 테스트 생성

class TodoTest {

    @Test
    public void userTest() {

        // given
        Todo todo = new Todo();
        User user = new User();

        // when
        todo.setUser(user);

        // then
        assertEquals(user, todo.getUser());
    }

    @Test
    public void titleTest() {

        // G
        Todo todo = new Todo();
        String testTitle = "테스트 제목";

        // W
        todo.setTitle(testTitle);

        // T
        assertEquals(testTitle, todo.getTitle());
    }

    @Test
    public void contentTest() {

        // G
        Todo todo = new Todo();
        String testContent = "테스트 내용";

        // W
        todo.setContent(testContent);

        // T
        assertEquals(testContent, todo.getContent());
    }

    @Test
    public void completeTest() {

        // G
        Todo todo = new Todo();

        // W
        todo.complete();

        //T
        assertTrue(todo.getIsCompleted());
    }
}