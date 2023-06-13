package entity;

import javax.persistence.*;
import java.time.LocalDate;

public class Task {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

        private String name;
        private String description;
        private LocalDate dueDate;
        private boolean completed;

    public Task(Long id, String name, String description,
                LocalDate dueDate, boolean completed, TodoList todolist) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.completed = completed;
        this.todolist = todolist;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public boolean isCompleted() {
        return completed;
    }

    public void setCompleted(boolean completed) {
        this.completed = completed;
    }

    public TodoList getTodolist() {
        return todolist;
    }

    public void setTodolist(TodoList todolist) {
        this.todolist = todolist;
    }

    @ManyToOne
    private  TodoList todolist;

    public void setTodoList(TodoList todoList) {
    }

    public String getContent() {
        return null;
    }

    public void setContent(String content) {
    }
}
