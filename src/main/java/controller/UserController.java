package controller;

import com.giterDone.entity.*;
import com.giterDone.repository.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;
    private final TodoRepository todoRepository;

    public UserController(UserRepository userRepository, TodoRepository todoRepository) {
        this.userRepository = userRepository;
        this.todoRepository = todoRepository;
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PostMapping("/{userId}/todos")
    public TodoList addTodo(@PathVariable Long userId, @RequestBody TodoList todoList) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        user.getTodoList().add(todoList);
        userRepository.save(user);
        return todoList;
    }

    @PutMapping("/todos/{todoId}")
    public TodoList updateTodo(@PathVariable Long todoId, @RequestBody TodoList updatedTodo) {
        TodoList todoList = todoRepository.findById(todoId)
                .orElseThrow(() -> new NoSuchElementException("TodoList not found"));
        todoList.setContent(updatedTodo.getContent());
        todoRepository.save(todoList);
        return todoList;
    }

    @DeleteMapping("/todos/{todoId}")
    public void deleteTodoList(@PathVariable Long todoId) {
        TodoList todoList = todoRepository.findById(todoId)
                .orElseThrow(() -> new NoSuchElementException("TodoList not found"));
        todoRepository.delete(todoList);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));
        userRepository.delete(user);
    }
}
