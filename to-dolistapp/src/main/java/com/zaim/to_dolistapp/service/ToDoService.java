package com.zaim.to_dolistapp.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zaim.to_dolistapp.dto.ToDoDTO;
import com.zaim.to_dolistapp.entity.ToDoEntity;
import com.zaim.to_dolistapp.repository.ToDoRepository;

@Service
public class ToDoService {
	@Autowired
	private ToDoRepository toDoRepository; //ToDoRepository
	
	@Autowired
	private ModelMapper modelMapper; //ModelMapper Bean
	
	//////////////////// CRUD ////////////////////
	///
	//CREATE
	public ToDoDTO create(ToDoDTO dto) {
		ToDoEntity toDoEntitiy = modelMapper.map(dto, ToDoEntity.class); // DTO -> Entity
		
		ToDoEntity saveEntitiy = toDoRepository.save(toDoEntitiy); // Kayıt işlemi
		
		return modelMapper.map(saveEntitiy, ToDoDTO.class); //Kaydedilen entity'i DTO olarak dönüştürür.
	}
	//END CREATE
	//READ
	public List<ToDoDTO> getAll() {
		List<ToDoEntity> entitiyList = toDoRepository.findAll(); //Kaydedilmiş verileri veritabanından getirir.
		
		//ModelMapper ile her bir entity DTO olur.
		return entitiyList.stream()
				.map(entitiy -> modelMapper.map(entitiy, ToDoDTO.class)).toList();
	}
	
	public ToDoDTO getByID(Long id) {
		Optional<ToDoEntity> optionalEntity = toDoRepository.findById(id);
		
		return optionalEntity.map(entitiy -> modelMapper.map(entitiy, ToDoDTO.class)).orElse(null); //Hiçbir veri yoksa null döndür.
	}
	//END READ
	//UPDATE
	public ToDoDTO update(Long id, ToDoDTO dto) {
		 Optional<ToDoEntity> optionalEntity = toDoRepository.findById(id); //Güncellenecek veri
		 
		 if(optionalEntity.isPresent()) {
			 ToDoEntity existingEntity = optionalEntity.get();
			 
			 existingEntity.setTitle(dto.getTitle()); //Başlık
			 existingEntity.setDescription(dto.getDescription()); //Açıklama
			 existingEntity.setCompleted(dto.isCompleted()); //Tamamlandı mı?
			 
			 ToDoEntity updateEntity = toDoRepository.save(existingEntity);
			 return modelMapper.map(updateEntity, ToDoDTO.class);
		 }
		 else return null; //Hiçbir veri yoksa null döndür.
	}
	//END UPDATE
	//DELETE
	public void delete(long id) {
		toDoRepository.deleteById(id);
	}
	//END DELETE
	///
	///////////////// END CRUD ///////////////////
	
} //end ToDo class
