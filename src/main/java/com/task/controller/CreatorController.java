package com.task.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.web.bind.annotation.RestController;

import com.task.entity.CreatorEntity;
import com.task.entity.TaskEntity;
import com.task.services.CreatorService;
import com.task.services.MailService;
import com.task.services.TaskService;

import jakarta.mail.MessagingException;
import jakarta.persistence.Column;
import lombok.Data;

@RestController
public class CreatorController {
	@Autowired
	private TaskService taskService;
	@Autowired
	private CreatorService creatorService;

	@Autowired
	private MailService mailService;
	
	@MutationMapping("sendEmailToCreator")
	private String sendEmail(@Argument("creatorEmailId") String creatorEmailId) throws MessagingException {
		try {

			System.out.println("creatorEmailId" + creatorEmailId);
			List<TaskEntity> tasksOfUser = taskService.findByCreator(creatorEmailId);
			System.out.println("tasksOfUser");

			StringBuilder emailContent = new StringBuilder();
			emailContent.append("Hello "+ ",\n\n");
			emailContent.append("Here are your tasks:\n");

			for (TaskEntity task : tasksOfUser) {
				emailContent.append("- " + task.getTitle() + ": " + task.getEndDate() + "\n");
			}
			System.out.println("emailContent" + emailContent.toString());
			mailService.sendEmail(creatorEmailId, "Tasks to be done", emailContent.toString());

			return "Email sent successfully!";
		} catch (Exception e) {
			return "Error sending email: " + e.getMessage();
		}
	}

	@MutationMapping("sendMail")
	public String sendMail(@Argument("to") String to, @Argument("subject") String subject,
			@Argument("text") String text) {
		try {
			mailService.sendEmail(to, subject, text);
			return "Email sent successfully!";
		} catch (Exception e) {
			return "Error sending email: " + e.getMessage();
		}
	}

	@MutationMapping("addCreator")
	private CreatorEntity addCreator(@Argument("creator") CreatorInput creatorInput) {
		CreatorEntity newCreator = new CreatorEntity();
		newCreator.setEmail(creatorInput.getEmail());
		newCreator.setName(creatorInput.getName());
		return this.creatorService.addCreator(newCreator);
	}
}

@Data
class TaskInput {
	@Column(name = "task_title")
	private String title;
	private String desc;
	private CreatorInput creator;
	private String startDate;
	private String endDate;
	private String status;
}

@Data
class CreatorInput {
	String name;
	String email;
}
