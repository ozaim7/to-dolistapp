package com.zaim.to_dolistapp.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "todo")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ToDoEntity {
    
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
    private String title; //Başlık

    private String description; //Açıklama

    private boolean completed; //Tamamlama
}
