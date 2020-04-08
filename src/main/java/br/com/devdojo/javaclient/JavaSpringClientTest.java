package br.com.devdojo.javaclient;

import br.com.devdojo.model.PageableResponse;
import br.com.devdojo.model.Student;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class JavaSpringClientTest {
    public static void main(String[] args) {

        Student studentPost = new Student();
        studentPost.setName("Test");
        studentPost.setEmail("artur@gmail.com");
        studentPost.setId(7L);
        JavaClientDAO dao = new JavaClientDAO();

//        Student studentById = dao.findById(1);
//        System.out.println(studentById);
//
//        List<Student> studentList = dao.listAll();
//        System.out.println(studentList);
//
//        Student save = dao.save(studentPost);
//        System.out.println(save);
//        dao.update(studentPost);
//
//        dao.delete(studentPost.getId());

    }
}
