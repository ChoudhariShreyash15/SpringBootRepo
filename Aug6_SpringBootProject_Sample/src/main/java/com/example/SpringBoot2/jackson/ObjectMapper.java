package com.example.SpringBoot2.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;
import java.io.IOException;

public class ObjectMapper {
    public static void main(String[] args) throws IOException, JsonProcessingException {
        ObjectMapper jacksonObjectMapper = new ObjectMapper();
//        jacksonObjectMapper.javaToJson();
//        jacksonObjectMapper.jsonToJava();
//        jacksonObjectMapper.javaToFile();
//        jacksonObjectMapper.fileToJava();
//        jacksonObjectMapper.check();
        jacksonObjectMapper.toStudentDto();
    }

    //Java to Json
    public void javaToJson() throws JsonProcessingException {
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        Student student = new Student(1, "Shreyash", 90);
        String s = objectMapper.writeValueAsString(student);
        System.out.println(s);
    }

    //Json to Java
    public void jsonToJava() throws JsonProcessingException {
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        String s = "{\"id\":1,\"name\":\"Shreyash\",\"marks\":90}";
        Student student = objectMapper.readValue(s, Student.class);
        System.out.println(student);
    }

    //Java To File
    public void javaToFile() throws IOException {
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        Student student = new Student(2,"Pratik",92);
        File file =new File( "E:\\Shreyash_1227\\Java\\IdeaProjects\\IdeaProjects\\SpringBoot2\\src\\main\\resources\\jackson.txt");
        objectMapper.writeValue(file,student);
    }

    //File To Java
    public void fileToJava() throws IOException {
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        String file = "E:\\Shreyash_1227\\Java\\IdeaProjects\\IdeaProjects\\SpringBoot2\\src\\main\\resources\\jackson.txt";
        Student student = objectMapper.readValue(new File(file), Student.class);
        System.out.println(student);
    }

    //Accessing each node using JsonNode
    public void check() throws JsonProcessingException {
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        JsonNode jsonNode = objectMapper.readTree("{\"id\": 1,\n" + "  \"name\": \"Shreyash\",\n" + "  \"address\": {\n" + "    \"area\": \"MG Road\",\n" + "    \"city\": \"Mumbai\",\n" + "    \"country\": {\n" + "      \"state\": \"Maharashtra\",\n" + "      \"country\": \"India\"\n" + "    }\n" + "  }\n" + "}\n");
//        System.out.println(jsonNode);
//        String id = jsonNode.get("id").asText();
//        System.out.println(id);
//        String name = jsonNode.get("name").asText();
//        System.out.println(name);
//        JsonNode address = jsonNode.get("address").get("city");
//        System.out.println(address);
//        ((ObjectNode) address).put("Landmark","Raghuvir Sweet Shop");
//        ((ObjectNode) address).remove("Landmark");
//        System.out.println(address);
    }

    //Student To StudentDto
    public void toStudentDto(){
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        Student student = new Student(3,"Mayank",60);
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES,false);
        StudentDto studentDto = objectMapper.convertValue(student, StudentDto.class);
        System.out.println(studentDto);
    }
}


@Data
@AllArgsConstructor
@NoArgsConstructor
class Student {
    private int id;
    private String name;
    private int marks;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Person {
    private int id;
    private String name;
    private Address address;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Address{
    private String area;
    private String city;
    private Country country;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Country {
    private String state;
    private String country;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class StudentDto {
    private int id;
    private int marks;
}