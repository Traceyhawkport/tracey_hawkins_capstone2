package controller;

import com.giterDone.entity.*;
import com.giterDone.repository.*;
import org.springframework.web.bind.annotation.*;



import java.util.*;

@RestController
@RequestMapping("/todos/{todoId}/tasks")
public class TaskController {

    private final TodoRepository todoListRepository;
    private final TaskRepository taskRepository;

    public TaskController(TodoRepository todoListRepository, TaskRepository taskRepository) {
        this.todoListRepository = todoListRepository;
        this.taskRepository = taskRepository;
    }

    @GetMapping("/{taskId}")
    public Task getTaskById(@PathVariable Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new NoSuchElementException("Task not found"));
    }

    @PostMapping
    public Task addTask(@PathVariable Long todoId, @RequestBody Task task) {
        TodoList todoList = todoListRepository.findById(todoId)
                .orElseThrow(() -> new NoSuchElementException("TodoList not found"));
        todoList.getTasks().add(task);
        task.setTodoList(todoList);
        return taskRepository.save(task);
    }

    @PutMapping("/{taskId}")
    public Task updateTask(@PathVariable Long taskId, @RequestBody Task updatedTask) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new NoSuchElementException("Task not found"));
        task.setContent(updatedTask.getContent());
        return taskRepository.save(task);
    }

    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new NoSuchElementException("Task not found"));
        taskRepository.delete(task);
    }
}


