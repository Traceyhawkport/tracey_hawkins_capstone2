package giterDone;

import com.giterDone.entity.*;
import com.giterDone.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GiterdoneApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private TodoRepository todoRepository;

	public static void main(String[] args) {
		SpringApplication.run(GiterdoneApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		// Create a user
		User user = new User();
		user.setUsername("John");
		user.setPassword("should be hashed");
		user.setEmail("john@example.com");

		// Save the user to the database
		user = userRepository.save(user);

		// Create a project
		Project project = new Project();
		project.setName("Project 1");
		project.setDescription("Description of Project 1");
		project.setStartDate(LocalDate.now());
		project.setEndDate(LocalDate.now().plusMonths(3));
		project.setUser(user);

		// Save the project to the database
		project = projectRepository.save(project);

		// Create a to-do list
		TodoList todoList = new TodoList();
		todoList.setName("Todo List 1");
		todoList.setDescription("Description of Todo List 1");
		todoList.setProject(project);

		// Save the to-do list to the database
		todoList = todoRepository.save(todoList);

		// Create a task
		Task task = new Task();
		task.setName("Task 1");
		task.setDescription("Description of Task 1");
		task.setDueDate(LocalDate.now().plusDays(7));
		task.setCompleted(false);
		task.setTodoList(todoList);

		// Save the task to the database
		task = taskRepository.save(task);

		// Add the task to the to-do list
		todoList.getTasks().add(task);

		// Update the to-do list in the database
		todoList = todoRepository.save(todoList);
	}
}
