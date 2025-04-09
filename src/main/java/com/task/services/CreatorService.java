package com.task.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.task.entity.CreatorEntity;
import com.task.repository.CreatorRepository;

@Service
public class CreatorService {
	@Autowired
	private CreatorRepository creatorRepository;
	
	public Optional<CreatorEntity> getCreatorByEmail(String email) {
        return this.creatorRepository.findById(email);
    }
	
	public CreatorEntity addCreator(CreatorEntity creatorInput) {
		return this.creatorRepository.save(creatorInput);
	}

}
