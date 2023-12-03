package com.sparta.todoparty.todo;

import com.sparta.todoparty.user.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

// Todo Entity 내 메서드 별 테스트 생성

class TodoTest {

    @Test
    public void setUserTest() {

        // given
        Todo todo = new Todo();
        User user = new User();

        // when
        todo.setUser(user);

        // then
        assertEquals(user, todo.getUser());
    }

    @Test
    public void setTitleTest() {

        // G
        Todo todo = new Todo();
        String testTitle = "테스트 제목";

        // W
        todo.setTitle(testTitle);

        // T
        assertEquals(testTitle, todo.getTitle());
    }

    @Test
    public void setContetnTest() {

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