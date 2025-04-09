package com.task.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.entity.TaskEntity;
import com.task.repository.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepository;
	
	public TaskEntity createAndUpdateTask(TaskEntity task) {
		return this.taskRepository.save(task);
	}
	
	public TaskEntity findTaskById(int taskId) {
		return this.taskRepository.findById(taskId).orElseThrow();
	}
	
	public List<TaskEntity> findAllTask(){
		return this.taskRepository.findAll();
	}
	
	public List<TaskEntity> findByCreator(String creatorEmailId){
		return this.taskRepository.findByCreatorEmail(creatorEmailId);
	}
	
	public List<TaskEntity> findByStatus(String status){
		return this.taskRepository.findByStatus(status);
	}
	
	public boolean deleteTask(int taskId) {
		return this.deleteTask(taskId);
	}
}
