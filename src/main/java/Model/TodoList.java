package Model;
import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private int id;
    private String name;
    private List<Task> tasks;

    public TodoList(int id, String name) {
        this.id = id;
        this.name = name;
        this.tasks = new ArrayList<Task>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void addTask(Task task) {
        tasks.add(task);
    }

    public void removeTask(Task task) {
        tasks.remove(task);
    }

    public List<Task> getTasks() {
        return tasks;
    }
}

