package br.com.jonathanferreira.spring.forum.controller.form;

import br.com.jonathanferreira.spring.forum.model.Course;
import br.com.jonathanferreira.spring.forum.model.Topic;
import br.com.jonathanferreira.spring.forum.repository.CourseRepository;
import com.sun.istack.NotNull;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class TopicForm {

    @NotNull @NotEmpty @Size(min=5)
    private String title;
    @NotNull @NotEmpty @Size(min=10)
    private String message;
    @NotNull @NotEmpty
    private String nameCourse;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getNameCourse() {
        return nameCourse;
    }

    public void setNameCourse(String nameCourse) {
        this.nameCourse = nameCourse;
    }

    public Topic Convert(CourseRepository repository) {
        Course course = repository.findByName(nameCourse);
        return new Topic(title, message, course);
    }
}
