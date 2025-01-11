package com.zaim.to_dolistapp.dto;


import lombok.Getter;
import lombok.Setter;
import jakarta.validation.constraints.NotEmpty;

@Getter
@Setter
public class ToDoDTO {
	
	@NotEmpty(message = "Boş bırakılamaz")
    private String title;
	
	@NotEmpty(message = "Boş bırakılamaz")
    private String description;
	
    private boolean completed;
}
