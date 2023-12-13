package com.devskiller.tasks.blog.model;

import com.devskiller.tasks.blog.model.dto.TaskDto;
import com.devskiller.tasks.blog.model.utilities.TaskStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
public class Task {
	@Id
	//@GeneratedValue
	private Long id;
	private String title;
	private String description;
	private TaskStatus status=TaskStatus.CREATED;

	public Long getId() {
		return id;
	}

	public Task(String title) {
		this.title = title;
	}
	public TaskDto toDto()
	{
		return new TaskDto(String.valueOf(id),description,status.name());
	}
}
