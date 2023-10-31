package com.oscar.pictures.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class MovieGenResConfig {
	@Bean
	public ModelMapper getMapper () { 
		
		return new ModelMapper();
	}
	
	@Bean
	public RestTemplate getRestObject() {
		
		return new RestTemplate();
	}
}
