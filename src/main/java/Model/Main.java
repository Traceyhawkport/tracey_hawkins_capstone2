package Model;

import java.util.Scanner;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import Model.Task;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Task> taskList = new ArrayList<Task>();

        while (true) {
            System.out.println("Select an operation:");
            System.out.println("1. Create a new task");
            System.out.println("2. View all tasks");
            System.out.println("3. Update a task");
            System.out.println("4. Delete a task");
            System.out.println("5. Exit");

            int choice = 0;
            try {
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number between 1 and 5.");
                scanner.nextLine(); // consume the new line character
                continue; // skip to next iteration of the while loop
            }
            scanner.nextLine(); // consume the new line character

            switch (choice) {
                case 1:
                    Task newTask = Task.createTask(scanner);
                    taskList.add(newTask);
                    break;
                case 2:
                    if (taskList.isEmpty()) {
                        System.out.println("No tasks found.");
                    } else {
                        for (Task task : taskList) {
                            System.out.println(task);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Enter the ID of the task to update:");
                    int taskId = 0;
                    try {
                        taskId = scanner.nextInt();
                    } catch (Exception e) {
                        System.out.println("Invalid input. Please enter a valid integer ID.");
                        scanner.nextLine(); // consume the new line character
                        break; // exit the switch statement and start the next iteration of the while loop
                    }
                    scanner.nextLine(); // consume the new line character

                    Task taskToUpdate = Task.findTaskById(taskId);
                    if (taskToUpdate == null) {
                        System.out.println("Task not found.");
                    } else {
                        taskToUpdate.updateTask(scanner);
                    }
                    break;
                case 4:
                    if (taskList.isEmpty()) {
                        System.out.println("No tasks found.");
                    } else {
                        Task.deleteTask(taskList, scanner);
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

            System.out.println();
        }
    }
}
