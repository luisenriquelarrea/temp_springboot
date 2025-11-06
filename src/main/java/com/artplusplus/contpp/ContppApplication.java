package com.artplusplus.contpp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.UserDetailsServiceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.artplusplus.contpp.storage.StorageProperties;
import com.artplusplus.contpp.storage.StorageService;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class, UserDetailsServiceAutoConfiguration.class})
@EnableJpaAuditing
@RestController
@EnableConfigurationProperties(StorageProperties.class)
public class ContppApplication {
	public static void main(String[] args) {
		SpringApplication.run(ContppApplication.class, args);
	}

	@Bean
    public ModelMapper getModelMapper() { 
        return new ModelMapper(); 
    }

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}
}
