package com.task.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
	 Optional<Task> findById(int taskId);
	 
	 List<Task> findByCreator(String creatorName);
	 
	 List<Task> findByStatus(String status);
}
