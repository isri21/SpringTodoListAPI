package com.taskapi.taskapi.DTOs;

import com.taskapi.taskapi.Models.Task;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class TaskDescriptionDTO {
	private Integer id;
	private String title;

	public TaskDescriptionDTO(Task task) {
		this.id = task.getId();
		this.title = task.getTitle();
	}
}
