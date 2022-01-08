package br.com.jonathanferreira.spring.forum.repository;

import br.com.jonathanferreira.spring.forum.model.Course;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository repository;

    @Test
    public void shouldLoadACourseByName() {
        String courseName = "HTML 5";
        Course course = repository.findByName(courseName);

        assertNotNull(course);
        assertEquals(courseName, course.getName());
    }

    @Test
    public void shouldReturnNullIfCourseDoesNotExists() {
        String courseName = "JPA";
        Course course = repository.findByName(courseName);

        assertNull(course);
    }
}