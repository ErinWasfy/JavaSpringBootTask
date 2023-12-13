package com.devskiller.tasks.blog.rest;

import com.devskiller.tasks.blog.model.Task;
import com.devskiller.tasks.blog.model.dto.TaskDto;
import com.devskiller.tasks.blog.model.utilities.TaskStatus;
import com.devskiller.tasks.blog.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Controller
@RestController
@RequestMapping("/taskapis")
public class TaskController {
	private final TaskRepository repository;

    @Autowired
    public TaskController(TaskRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/{id}")
    public TaskDto findById(@PathVariable Long id) {
        Optional<Task> task = repository.findById(id);
        if (task.isPresent()) {
            return task.get().toDto();
        }
        throw new TaskNotFound(id);
    }
	@PostMapping("/tasks")
	public ResponseEntity<Long>  create(@RequestBody TaskDto dto) {
		Task task = new Task(dto.getTitle());
		task.setDescription(dto.getDescription());
		task.setStatus(TaskStatus.CREATED);
		return new ResponseEntity<Long>(repository.save(task).getId(),HttpStatus.CREATED);
	}

	@PutMapping("/tasks/{id}")
	public ResponseEntity<String> update(@RequestBody TaskDto mainTask,@PathVariable("id") Long id) {
		Optional<Task> found = repository.findById(id);
		if (found.isPresent()) {
			Task task = found.get();
			Optional<TaskStatus> taskStatus = statusOf(mainTask);
			if(!taskStatus.isPresent())
				return new ResponseEntity<>("",HttpStatus.BAD_REQUEST);
			if (mainTask.getDescription() != null) {
				task.setDescription(mainTask.getDescription());
			}
			if (mainTask.getTitle() != null) {
				task.setTitle(mainTask.getTitle());
			}
			return new ResponseEntity<>(HttpStatus.OK);
		}
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

	//
    private Optional<TaskStatus> statusOf(TaskDto dto) {
        return Optional.of(TaskStatus.valueOf(dto.getStatus()));

    }
	@DeleteMapping("/tasks/{id}")
	public ResponseEntity<TaskDto> delete(@PathVariable("id") Long id)
	{
		Optional<Task> task = repository.findById(id);
		if (task.isPresent()) {
			return new ResponseEntity<TaskDto>(HttpStatus.OK);
		}
		return new ResponseEntity<TaskDto>(HttpStatus.NOT_FOUND);
	}

    @GetMapping("/tasks")
    public ResponseEntity<List<TaskDto>> findAll() {
       List<Task> list= new ArrayList<>();//(List<Task>) (repository.findAll());
	   Task task1=new Task("test");
	   task1.setId(1L);
	   task1.setDescription("Test Description");
		Task task2=new Task("test2");
		task2.setId(2L);
		task2.setDescription("Test Description2");
		list.add(task1);
        list.add(task2);
		return new ResponseEntity<List<TaskDto>>(list.stream().map(mp->mp.toDto()).toList(), HttpStatus.OK);
    }
	public  class TaskNotFound extends RuntimeException
	{
		public TaskNotFound(Long id)
		{
			super("Task with id"+id+" not found.");
		}
	}
}
