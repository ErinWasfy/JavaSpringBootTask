package com.devskiller.tasks.blog.repository;

import com.devskiller.tasks.blog.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpProjectRepository extends JpaRepository<Project,Long> {
}
