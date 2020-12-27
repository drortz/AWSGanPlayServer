package com.ganplay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class GanPlayApplication {

	public static void main(String[] args) {
		SpringApplication.run(GanPlayApplication.class, args);
	}
	
	@CrossOrigin
	@GetMapping("/")
	public String hellow()
	{
		return "{\"Hello\" : \"Hello\"}";
	}
}
