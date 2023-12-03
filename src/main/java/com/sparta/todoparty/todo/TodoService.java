package com.sparta.todoparty.todo;

import com.sparta.todoparty.user.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    public TodoResponseDto createPost(TodoRequestDto dto, User user) {
        Todo todo = new Todo(dto);
        todo.setUser(user);

        todoRepository.save(todo);

        return new TodoResponseDto(todo);
    }

    public TodoResponseDto getTodo(Long todoId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 할 일 ID입니다."));
        return new TodoResponseDto(todo);
    }
}
