package com.taskapi.taskapi.Controllers;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
		return new ResponseEntity<>(service.getTasks(), HttpStatus.OK);
	}

	@GetMapping("/tasks/{id}")
	public ResponseEntity<TaskDTO> getTask(@PathVariable int id) {
		return new ResponseEntity<>(service.getTask(id), HttpStatus.OK);
	}

	@PostMapping("/tasks")
	public ResponseEntity<TaskDTO> addTask(@RequestBody TaskDTO task) {
		return new ResponseEntity<>(service.addTask(task), HttpStatus.CREATED); 
	}

	@PutMapping("/tasks/{id}")
	public ResponseEntity<TaskDTO> getTask(@PathVariable int id, @RequestBody TaskDTO task) {
		System.out.println(task);
		return new ResponseEntity<>(service.updateTask(task, id), HttpStatus.OK);
	}

	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<Void> deleteTask(@PathVariable int id) {
		service.deleteTask(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
