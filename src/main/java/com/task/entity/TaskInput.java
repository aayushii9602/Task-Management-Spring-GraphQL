package com.task.entity;

import jakarta.persistence.Column;
import lombok.Data;

@Data
public class TaskInput {
	@Column(name="task_title")
	private String title;
	private String desc;
	private String creator;
	private String startDate;
	private String endDate;
	private String status;
}
