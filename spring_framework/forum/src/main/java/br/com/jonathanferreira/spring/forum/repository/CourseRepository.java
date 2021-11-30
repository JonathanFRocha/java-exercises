package br.com.jonathanferreira.spring.forum.repository;

import br.com.jonathanferreira.spring.forum.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Course findByName(String courseName);
}
