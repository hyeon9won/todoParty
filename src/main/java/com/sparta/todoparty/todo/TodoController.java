package com.sparta.todoparty.todo;

import com.sparta.todoparty.CommonResponseDto;
import com.sparta.todoparty.user.UserDetailsImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/todos")
@RestController
@RequiredArgsConstructor
public class TodoController {

    private final TodoService todoService;

    @PostMapping
    public ResponseEntity<TodoResponseDto> postTodo(@RequestBody TodoRequestDto todoRequestDto, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        TodoResponseDto responseDto = todoService.createPost(todoRequestDto, userDetails.getUser());

        return ResponseEntity.status(201).body(responseDto);
    }

    // 단건 조회
    @GetMapping("/{todoId}")
    public ResponseEntity<CommonResponseDto> getTodo(@PathVariable Long todoId) {
        try {
            TodoResponseDto responseDto = todoService.getTodo(todoId);
            return ResponseEntity.ok().body(responseDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(new CommonResponseDto(e.getMessage(), HttpStatus.BAD_REQUEST.value()));
        }
    }

    @GetMapping
    public ResponseEntity<CommonResponseDto> getTodoList() {

        return ResponseEntity.ok().build();
    }
}
