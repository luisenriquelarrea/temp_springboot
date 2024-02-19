package com.artplusplus.contpp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ContppApplication {
	public static void main(String[] args) {
		SpringApplication.run(ContppApplication.class, args);
	}

	@Bean
    public ModelMapper getModelMapper() { 
        return new ModelMapper(); 
    } 
}
