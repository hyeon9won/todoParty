package com.sparta.todoparty.todo;

import com.sparta.todoparty.user.User;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TodoListResponseDto {
    private User user;
    private List<TodoResponseDto> todoList;
}
