package com.sparta.todoparty.user;

import com.sparta.todoparty.todo.Todo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Entity
@NoArgsConstructor
@Table(name = "users")
public class User {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public Long getId(Long id) {
        return id;
    }
}
