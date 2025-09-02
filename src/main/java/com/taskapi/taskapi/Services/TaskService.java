package com.taskapi.taskapi.Services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.taskapi.taskapi.DTOs.TaskDTO;
import com.taskapi.taskapi.Repositories.TaskRepository;

@Service
public class TaskService {
	private final TaskRepository repo;

	public TaskService(TaskRepository repo) {
		this.repo = repo;
	}

	public List<TaskDTO> getTasks() {
		return repo.findAll()
					.stream()
					.map(n -> new TaskDTO(n))
					.toList();
	}
}
