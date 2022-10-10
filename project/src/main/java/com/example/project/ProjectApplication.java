package com.example.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
import com.fasterxml.jackson.core.sym.Name;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
@SpringBootApplication
@RestController

public class ProjectApplication {

public static void main(String[] args) {
SpringApplication.run(ProjectApplication.class, args);

}

@GetMapping("/hello")
public String hello(@RequestParam(value = "name", defaultValue = "World") String name){//// designed to take a String value called "name" and then combines with "H ello", if no arg is passed default value will be "World"
return String.format("Hello %s!", name);
}

@GetMapping("/Json") //// getting json string where id in args try:"http://localhost:8080/Json?id=1"
public String Json(@RequestParam(value = "id", defaultValue = "2") String id) {

String example1 = "{ id: 1 ,"+
"content:Annamalai!";

String example2 = "{ id: 2 ,"+
"content:Mikael!}";
JsonObject x = new JsonObject();

x.addProperty("1", example1);
x.addProperty("2", example2);
return String.format("Json %s!", x.getAsJsonPrimitive(id)); //default value is 2
}



@GetMapping("/Gson")
public String Gson(@RequestParam(value = "id", defaultValue = "2") String id) {
Gson GSTest = new GsonBuilder().create();
String example1 = "{\n" +
		"\"id: \"1\",\n"+
"\"content\": \"Hello, World!\",\n"+"}";

GSTest.toJson(example1);
String example2 = "{\n" +
		"\"id: \"2\",\n"+
    "\"content\": \"Hello, X!\",\n"+"}";

GSTest.toJson(example2);

return String.format("Json %s!", id);
}
}