package controller;

import com.giterDone.entity.*;
import com.giterDone.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.lang.*;

import java.util.*;

@RestController
@RequestMapping("/projects")
public class ProjectController {

    private final com.giterDone.repository.projectRepository projectRepository;

    @Autowired
    public ProjectController(projectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("/{id}")
    public Project getProjectById(@PathVariable Long id) {
        return projectRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Project not found"));
    }

    @PostMapping
    public Project createProject(@RequestBody Project project) {
        return (Project) projectRepository.save(project);
    }

    @PutMapping("/{id}")
    public Project updateProject(@PathVariable Long id, @RequestBody Project updatedProject) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Project not found"));
        project.setName(updatedProject.getName());
        // Update other properties as needed
        return (Project) projectRepository.save(project);
    }

    @DeleteMapping("/{id}")
    public void deleteProject(@PathVariable Long id) {
        Project project = projectRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Project not found"));
        projectRepository.delete(project);
    }
}
