package com.taskapi.taskapi.DTOs;
import java.time.LocalDate;
import com.taskapi.taskapi.Models.Task;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TaskDTO {
	private int id;

	@NotNull
	@NotBlank
	private String title;

	@NotNull
	@NotBlank
	private String description;

	@FutureOrPresent
	@NotNull
	private LocalDate dueDate;

	public TaskDTO(Task task) {
		this.id = task.getId();
		this.title = task.getTitle();
		this.description = task.getDescription();
		this.dueDate = task.getDueDate();
	}
}
