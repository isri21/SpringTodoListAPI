package com.taskapi.taskapi.Controllers;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.taskapi.taskapi.DTOs.TaskDTO;
import com.taskapi.taskapi.Services.TaskService;

@RestController
public class TaskController {
	private TaskService service;

	public TaskController(TaskService service) {
		this.service = service;
	}

	@GetMapping("/tasks")
	public ResponseEntity<List<TaskDTO>> getTasks() {
		return new ResponseEntity<>(service.getTasks(), HttpStatus.FOUND);
	}

}
