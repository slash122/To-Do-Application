package dev.todoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@SpringBootApplication
@RestController
public class ToDoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ToDoApplication.class, args);
		System.out.println("App started on port 8080");
	}

	@GetMapping("/")
	public String getHello() {
		return "Hello World!";
	}

	public static String currentTimeAsString() {
		return LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
	}
}

