package br.com.devdojo.javaclient;

import br.com.devdojo.model.Student;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.List;

public class JavaSpringClientTest {
    public static void main(String[] args) {
        RestTemplate restTemplate = new RestTemplateBuilder()
                .rootUri("http://localhost:8080/v1/protected/students")
                .basicAuthentication("arturlansoni", "13032001").build();
       Student student = restTemplate.getForObject("/{id}", Student.class, 1);
       ResponseEntity<Student> forEntity = restTemplate.getForEntity("/{id}", Student.class, 1);
       Student[] students = restTemplate.getForObject("/", Student[].class);
       restTemplate.exchange("/", HttpMethod.GET, null,
               new ParameterizedTypeReference<List<Student>>() {       });
    }
}
