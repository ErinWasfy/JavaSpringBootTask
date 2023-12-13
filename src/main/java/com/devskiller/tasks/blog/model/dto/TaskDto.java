package com.devskiller.tasks.blog.model.dto;

import com.devskiller.tasks.blog.model.Task;
import com.devskiller.tasks.blog.model.utilities.TaskStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
public class TaskDto {
	String title;
	String description;
	String status="CREATED";

	public TaskDto(String title, String description, String status) {
		this.title = title;
		this.description = description;
		this.status = status;
	}
}
