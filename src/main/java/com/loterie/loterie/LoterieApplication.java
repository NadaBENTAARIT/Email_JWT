package com.loterie.loterie;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class LoterieApplication {
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();

	}

	public static void main(String[] args) {
		SpringApplication.run(LoterieApplication.class, args);
	}
}

