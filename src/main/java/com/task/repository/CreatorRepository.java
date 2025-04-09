package com.task.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.task.entity.CreatorEntity;

@Repository
public interface CreatorRepository extends JpaRepository<CreatorEntity, String>{

}
