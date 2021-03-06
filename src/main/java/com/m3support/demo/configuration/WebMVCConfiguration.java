package com.m3support.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebMVCConfiguration implements WebMvcConfigurer{
	
	public void addCORSMappings(CorsRegistry registry) {
		
		registry.addMapping("/api").allowedOrigins("http://localhost:4200");
	}

	
}
