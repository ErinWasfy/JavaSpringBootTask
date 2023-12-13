package com.devskiller.tasks.blog.repository;

import com.devskiller.tasks.blog.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long> {
}
