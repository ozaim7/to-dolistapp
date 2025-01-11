package com.zaim.to_dolistapp.modelmapper;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ToDoModelMapper {

    @Bean
    public ModelMapper modelMapper() { // @Autowired ModelMapper modelMapper;
		return new ModelMapper();
	}
}
