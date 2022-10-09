package com.example.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController

public class ProjectApplication {

public static void main(String[] args) {
SpringApplication.run(ProjectApplication.class, args);
}

@GetMapping("/hello")
public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {//// designed to take a String value called "name" and then combines with "H ello", if no arg is passed default value will be "World"
return String.format("Hello %s!", name);
}
}