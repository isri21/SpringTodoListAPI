package com.taskapi.taskapi.DTOs;

import java.time.LocalDate;

import com.taskapi.taskapi.Models.Task;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskDTO {
	private int id;
	private String title;
	private String description;
	private LocalDate due_date;
	private String status;

	public TaskDTO(Task task) {
		this.id = task.getId();
		this.title = task.getTitle();
		this.description = task.getDescription();
		this.due_date = task.getDueDate();
		this.status = task.getStatus();
	}
}
