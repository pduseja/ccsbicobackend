package com.ccsbi.co;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication
public class CcsbicobackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(CcsbicobackendApplication.class, args);
	}
	
	@Bean
	public Mapper mapper() {
	    return new DozerBeanMapper();
	}
}
