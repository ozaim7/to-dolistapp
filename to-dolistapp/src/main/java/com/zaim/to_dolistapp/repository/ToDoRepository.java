package com.zaim.to_dolistapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.zaim.to_dolistapp.entity.ToDoEntity;

//JPA üzerinden CRUD işlemlerini sağlar.
public interface ToDoRepository extends JpaRepository<ToDoEntity, Long>{
	
}