package com.task.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.task.entity.CreatorEntity;
import com.task.entity.TaskEntity;
import com.task.services.TaskService;

@Controller
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@QueryMapping("getTask")
	public TaskEntity getTask(@Argument("taskId") int taskId) {
	    return this.taskService.findTaskById(taskId);
}
	
	@QueryMapping("allTasks")
	public List<TaskEntity> getallTask() {
		return this.taskService.findAllTask();
	}
	
	@QueryMapping("getTaskByCreator")
	public List<TaskEntity>getTaskByCreator(@Argument("creatorEmailId")String creatorEmailId){
		return this.taskService.findByCreator(creatorEmailId);
	}
	
	@QueryMapping("getTasksByStatus")
	public List<TaskEntity> getTasksByStatus(@Argument("status") String status) {
		return this.taskService.findByStatus(status);
    }

	
	@MutationMapping("addTask")
	public TaskEntity addTask(@Argument("task") TaskInput taskInput) {
		System.out.println("TaskEntity input:"+taskInput);
		TaskEntity TaskEntity=new TaskEntity();
		TaskEntity.setTitle(taskInput.getTitle());
		TaskEntity.setDesc(taskInput.getDesc());
		CreatorEntity creatorEntity = new CreatorEntity();
		creatorEntity.setName(taskInput.getCreator().getName());
		creatorEntity.setEmail(taskInput.getCreator().getEmail());
		TaskEntity.setCreator(creatorEntity);
		TaskEntity.setStartDate(taskInput.getStartDate());
		TaskEntity.setEndDate(taskInput.getEndDate());
		TaskEntity.setStatus(taskInput.getStatus());
		return this.taskService.createAndUpdateTask(TaskEntity);
	}
	
	@MutationMapping("updateTaskStatus")
	public TaskEntity updateTaskStatus(@Argument("taskId") int taskId, @Argument("status") String status) {
        TaskEntity TaskEntity = this.taskService.findTaskById(taskId);
        TaskEntity.setStatus(status);
        return this.taskService.createAndUpdateTask(TaskEntity);
    }

	@MutationMapping("deleteTask")
    public Boolean deleteTask(@Argument("taskId") int taskId) {
        return this.taskService.deleteTask(taskId);
    }
}
