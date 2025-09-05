package com.taskapi.taskapi.Services;
import java.util.List;
import org.springframework.stereotype.Service;
import com.taskapi.taskapi.DTOs.TaskDTO;
import com.taskapi.taskapi.DTOs.TaskDescriptionDTO;
import com.taskapi.taskapi.Models.Task;
import com.taskapi.taskapi.Repositories.TaskRepository;
import com.taskapi.taskapi.Exceptions.TaskNotFoundException;

@Service
public class TaskService {
	private final TaskRepository repo;

	public TaskService(TaskRepository repo) {
		this.repo = repo;
	}

	public List<TaskDescriptionDTO> getTasks() {
		return repo.findAll()
					.stream()
					.map(n -> new TaskDescriptionDTO(n))
					.toList();
	}

	public TaskDTO getTask(int id) {
		Task task = repo.findById(id).orElseThrow(() -> new TaskNotFoundException());		
		return new TaskDTO(task);
		
	}

	public TaskDTO addTask(TaskDTO taskDto) {
		Task newTask = new Task();
		newTask.setTitle(taskDto.getTitle());
		newTask.setDescription(taskDto.getDescription());
		newTask.setDueDate(taskDto.getDueDate());
		newTask.setStatus(taskDto.getStatus());
		newTask.setCreatedAt(java.time.LocalDate.now());

		Task saved = repo.save(newTask);

		return new TaskDTO(saved);
		
		
	}

	public TaskDTO updateTask(TaskDTO updatedTask, int id) {

		Task task = repo.findById(id).orElseThrow(() -> new TaskNotFoundException());

		task.setTitle(updatedTask.getTitle());
		task.setDescription(updatedTask.getDescription());
		task.setDueDate(updatedTask.getDueDate());
		task.setStatus(updatedTask.getStatus());
		task.setCreatedAt(java.time.LocalDate.now());

		Task saved = repo.save(task);

		return new TaskDTO(saved);

	}

	public void deleteTask(int id) {
		Task task = repo.findById(id).orElseThrow(() -> new TaskNotFoundException());
		repo.delete(task);
	}
}
