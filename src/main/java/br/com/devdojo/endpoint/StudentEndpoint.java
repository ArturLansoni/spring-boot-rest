package br.com.devdojo.endpoint;

import br.com.devdojo.error.CustomErrorType;
import br.com.devdojo.model.Student;
import br.com.devdojo.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;

@RestController
@RequestMapping("students")
public class StudentEndpoint {
    private final DateUtil dateUtil;

    public StudentEndpoint(DateUtil dateUtil) {
        this.dateUtil = dateUtil;
    }


    @GetMapping
    public ResponseEntity<?> getAll(){
        return new ResponseEntity<>(Student.studentList, HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id){
        Student student = new Student();
        student.setId(id);
        int index = Student.studentList.indexOf(student);

        if(index == -1)
            return new ResponseEntity<>(new CustomErrorType("Student not found"), HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(Student.studentList.get(index), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> insert(@RequestBody Student student){
        Student.studentList.add(student);

        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Student student){
        Student.studentList.remove(student);

        return new ResponseEntity<>( HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Student student){
        Student.studentList.remove(student);
        Student.studentList.add(student);

        return new ResponseEntity<>( HttpStatus.OK);
    }
}