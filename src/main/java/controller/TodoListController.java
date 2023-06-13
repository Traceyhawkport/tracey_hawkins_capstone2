package controller;

import com.giterDone.entity.*;
import com.giterDone.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/todolists")
public class TodoListController {

    private final TodoRepository todoListRepository;

    @Autowired
    public TodoListController(TodoRepository todoListRepository) {
        this.todoListRepository = todoListRepository;
    }

    @GetMapping
    public List<TodoList> getAllTodoLists() {
        return todoListRepository.findAll();
    }

    @GetMapping("/{id}")
    public TodoList getTodoListById(@PathVariable Long id) {
        return todoListRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("TodoList not found"));
    }

    @PostMapping
    public TodoList createTodoList(@RequestBody TodoList todoList) {
        return todoListRepository.save(todoList);
    }

    @PutMapping("/{id}")
    public TodoList updateTodoList(@PathVariable Long id, @RequestBody TodoList updatedTodoList) {
        TodoList todoList = todoListRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("TodoList not found"));
        todoList.setId(updatedTodoList.getId());
        // Update other properties as needed
        return todoListRepository.save(todoList);
    }

    @DeleteMapping("/{id}")
    public void deleteTodoList(@PathVariable Long id) {
        TodoList todoList = todoListRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("TodoList not found"));
        todoListRepository.delete(todoList);
    }
}

