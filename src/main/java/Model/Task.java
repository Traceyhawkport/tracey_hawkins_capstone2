package Model;

import java.util.*;
import java.time.LocalDate;

public class Task {

    private int taskID;
    private String taskName;
    private String description;
    private LocalDate dueDate;
    private boolean isComplete;
    private static ArrayList<Task> taskList = new ArrayList<Task>();

    public Task(int taskID, String taskName, LocalDate dueDate, String description, boolean isComplete) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.description = description;
        this.isComplete = isComplete;
        taskList.add(this);
    }

    public Task(String taskName, LocalDate dueDate, String description) {
        this.taskName = taskName;
        this.dueDate = dueDate;
        this.description = description;
        this.isComplete = false;
    }

    public static Task findTaskById(int taskId) {
        for (Task task : taskList) {
            if (task.getTaskID() == taskId) {
                return task;
            }
        }
        // if no task with the given ID is found, return null
        return null;
    }

    public int getTaskID() {
        return taskID;
    }

    public void setTaskID(int id) {
        this.taskID = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String name) {
        this.taskName = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String desc) {
        this.description = desc;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate date) {
        this.dueDate = date;
    }

    public boolean getIsComplete() {
        return isComplete;
    }

    public void setIsComplete(boolean isComplete) {
        this.isComplete = isComplete;
    }

    public static Task createTask(Scanner scanner) {
        System.out.println("Enter task name:");
        String taskName = scanner.nextLine();
        System.out.println("Enter due date (yyyy-mm-dd):");
        LocalDate dueDate = LocalDate.parse(scanner.nextLine());
        System.out.println("Enter task description:");
        String description = scanner.nextLine();
        Task newTask = new Task(taskList.size() + 1, taskName, dueDate, description, false);
        taskList.add(newTask);
        System.out.println("New task created!");
        return newTask;
    }

    // update an existing task
    public void updateTask(Scanner scanner) {
        System.out.println("Enter new task name (or press Enter to keep current name):");
        String taskName = scanner.nextLine();
        if (!taskName.isEmpty()) {
            this.setTaskName(taskName);
        }
        System.out.println("Enter new due date (yyyy-mm-dd) (or press Enter to keep current due date):");
        String dueDateString = scanner.nextLine();
        if (!dueDateString.isEmpty()) {
            LocalDate dueDate = LocalDate.parse(dueDateString);
            this.setDueDate(dueDate);
        }
        System.out.println("Enter new task description (or press Enter to keep current description):");
        String description = scanner.nextLine();
        if (!description.isEmpty()) {
            this.setDescription(description);
        }
        System.out.println("Task updated!");
    }

    // delete an existing task
    public static void deleteTask(List<Task> taskList, Scanner scanner) {
        System.out.println("Enter the ID of the task to delete:");
        int taskId = scanner.nextInt();
        scanner.nextLine(); // consume the new line character

        Task taskToDelete = findTaskById(taskId);
        if (taskToDelete == null) {
            System.out.println("Task not found.");
        } else {
            taskList.remove(taskToDelete);
            System.out.println("Task deleted.");
        }
    }


}
