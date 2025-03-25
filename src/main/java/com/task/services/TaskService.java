package com.task.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.entity.Task;
import com.task.repository.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepository;
	
	public Task createAndUpdateTask(Task task) {
		return this.taskRepository.save(task);
	}
	
	public Task findTaskById(int taskId) {
		return this.taskRepository.findById(taskId).orElseThrow();
	}
	
	public List<Task> findAllTask(){
		return this.taskRepository.findAll();
	}
	
	public List<Task> findByCreator(String creatorName){
		return this.taskRepository.findByCreator(creatorName);
	}
	
	public List<Task> findByStatus(String status){
		return this.taskRepository.findByStatus(status);
	}
	
	public boolean deleteTask(int taskId) {
		return this.deleteTask(taskId);
	}
}
