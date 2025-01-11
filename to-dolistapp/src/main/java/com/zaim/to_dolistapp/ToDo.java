package com.zaim.to_dolistapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zaim.to_dolistapp.dto.ToDoDTO;
import com.zaim.to_dolistapp.service.ToDoService;

import io.swagger.v3.oas.annotations.Operation;


@RestController
@RequestMapping("/api/todo")
public class ToDo {
	
	@Autowired
	private ToDoService toDoService;
	
	//CREATE
	@Operation(summary = "Yeni bir görev oluştur.") //@Operation Swagger ile tanımlanan bir REST API ' yi görselleştirmenizi ve test etmenizi sağlar
	@PostMapping // "/api/todos"
	public ToDoDTO createToDo(@RequestBody ToDoDTO toDoDTO) { return toDoService.create(toDoDTO); } //Yeni bir görev oluşturur.
	//END CREATE
	
	//READ
	@Operation(summary = "Kayıtların hepsini listele.") 
	@GetMapping
	public List<ToDoDTO> getAllToDoDTOs(){ return toDoService.getAll(); } //Listeli bir şekilde tüm kayıtları getirir
	
	@Operation(summary = "ID ile kayıt getir.")
	@GetMapping("/{id}")
	public ToDoDTO getToDoById(@PathVariable Long id) { return toDoService.getByID(id); } //Görevin id'si ile getirir
	//END READ
	
	//UPDATE
	@Operation(summary = "Bir görevi güncelle.")
	@PutMapping("/{id}")
	public ToDoDTO updateToDoDTO(@PathVariable Long id, @RequestBody ToDoDTO toDoDTO) { return toDoService.update(id, toDoDTO); }
	//Görevin id'sini hedef alarak günceller
	//END UPDATE
	
	//DELETE
	@Operation(summary = "Bir görevi sil")
	@DeleteMapping("/{id}")
	public void deleteToDo(@PathVariable Long id) {toDoService.delete(id);} //Görevin id'sini hedef alarak siler
	
}//END ToDo class
