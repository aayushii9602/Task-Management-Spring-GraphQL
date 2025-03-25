package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.task.entity.Task;
import com.task.entity.TaskInput;
import com.task.services.TaskService;

@Controller
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@QueryMapping("getTask")
	public Task getTask(@Argument("taskId") int taskId) {
	    return this.taskService.findTaskById(taskId);
}
	
	@QueryMapping("allTasks")
	public List<Task> getallTask() {
		return this.taskService.findAllTask();
	}
	
	@QueryMapping("getTaskByCreator")
	public List<Task>getTaskByCreator(@Argument("creatorName")String creatorName){
		return this.taskService.findByCreator(creatorName);
	}
	
	@QueryMapping("getTasksByStatus")
	public List<Task> getTasksByStatus(@Argument("status") String status) {
		return this.taskService.findByStatus(status);
    }

	
	@MutationMapping("addTask")
	public Task addTask(@Argument("task") TaskInput taskInput) {
		System.out.println("task input:"+taskInput);
		Task task=new Task();
		task.setTitle(taskInput.getTitle());
		task.setDesc(taskInput.getDesc());
		task.setCreator(taskInput.getCreator());
		task.setStartDate(taskInput.getStartDate());
		task.setEndDate(taskInput.getEndDate());
		task.setStatus(taskInput.getStatus());
		return this.taskService.createAndUpdateTask(task);
	}
	
	@MutationMapping("updateTaskStatus")
	public Task updateTaskStatus(@Argument("taskId") int taskId, @Argument("status") String status) {
        Task task = this.taskService.findTaskById(taskId);
        task.setStatus(status);
        return this.taskService.createAndUpdateTask(task);
    }

	@MutationMapping("deleteTask")
    public Boolean deleteTask(@Argument("taskId") int taskId) {
        return this.taskService.deleteTask(taskId);
    }
}
