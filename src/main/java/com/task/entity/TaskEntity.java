package com.task.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="task")
@Data
public class TaskEntity {
	@Id
	@Column(name="task_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int taskId;

	private String title;
	private String desc;
	@ManyToOne
    private CreatorEntity creator;

	private String startDate;
	private String endDate;
	private String status;

}
