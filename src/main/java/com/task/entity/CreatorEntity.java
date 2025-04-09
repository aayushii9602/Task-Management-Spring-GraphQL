package com.task.entity;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="creator")
public class CreatorEntity {
	private String name;
	
	@Id
	private String email;
	
	@OneToMany(mappedBy = "creator")
    private Set<TaskEntity> tasks;

}
