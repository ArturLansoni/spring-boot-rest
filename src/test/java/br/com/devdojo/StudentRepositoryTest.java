package br.com.devdojo;

import br.com.devdojo.model.Student;
import br.com.devdojo.repository.StudentRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.ConstraintViolationException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class StudentRepositoryTest {
    @Autowired
    private StudentRepository studentRepository;
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void createShouldPersistData() {
        Student student = new Student("William", "william@gmail.com");
        this.studentRepository.save(student);
        assertThat(student.getId()).isNotNull();
        assertThat(student.getName()).isEqualTo("William");
        assertThat(student.getEmail()).isEqualTo("william@gmail.com");
    }

    @Test
    public void deleteShouldPersistData() {
        Student student = new Student("William", "william@gmail.com");
        this.studentRepository.save(student);
        this.studentRepository.delete(student);
        assertThat(studentRepository.findById(student.getId())).isEmpty();
    }

    @Test
    public void updateShouldChangeAndPersistData() {
        Student student = new Student("William", "william@devdojo.com.br");
        this.studentRepository.save(student);
        student.setName("William222");
        student.setEmail("william222@devdojo.com.br");
        this.studentRepository.save(student);
        student = this.studentRepository.findById(student.getId()).orElse(new Student());
        assertThat(student.getName()).isEqualTo("William222");
        assertThat(student.getEmail()).isEqualTo("william222@devdojo.com.br");
    }

    @Test
    public void findByNameIgnoreCaseContainingShouldIgnoreCase() {
        Student student = new Student("William", "william@gmail.com");
        Student student2 = new Student("william", "william22@gmail.com");
        this.studentRepository.save(student);
        this.studentRepository.save(student2);
        List<Student> studentList = studentRepository.findByNameIgnoreCaseContaining("william");
        assertThat(studentList.size()).isEqualTo(2);
    }

    @Test
    public void createWhenNameIsNullShouldThrowConstraintViolationException(){
        thrown.expect(ConstraintViolationException.class);
        thrown.expectMessage("The field name is required");
        this.studentRepository.save(new Student());
        entityManager.flush();
    }

    @Test
    public void createWhenEmailIsNullShouldThrowConstraintViolationException() {
        thrown.expect(ConstraintViolationException.class);
        Student student = new Student();
        student.setName("William");
        this.studentRepository.save(student);
        entityManager.flush();
    }

    @Test
    public void createWhenEmailIsNotValidShouldThrowConstraintViolationException() {
        thrown.expect(ConstraintViolationException.class);
        thrown.expectMessage("The field email is required");
        Student student = new Student();
        student.setName("William");
        student.setEmail("William");
        this.studentRepository.save(student);
        entityManager.flush();
    }

}
