package com.task.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.entity.TaskEntity;

@Repository
public interface TaskRepository extends JpaRepository<TaskEntity, Integer> {
	 Optional<TaskEntity> findById(int taskId);
	 
	 List<TaskEntity> findByCreatorEmail(String email);
	 
	 List<TaskEntity> findByStatus(String status);
}
