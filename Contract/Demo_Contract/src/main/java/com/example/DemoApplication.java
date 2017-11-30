package com.example;

import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

	}
	@RestController
	public class Controller {

		
		@GetMapping("/example")
		ResponseEntity<List<String>> Example() {
			return ResponseEntity.status(200).body(Arrays.asList("harshita", "gayatri"));
		}

}
}