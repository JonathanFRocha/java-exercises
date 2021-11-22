package br.com.jonathanferreira.javaFundamentals.modernJava;

import br.com.jonathanferreira.javaFundamentals.modernJava.entity.Course;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestingCourse {

    public static void main(String[] args) {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course("Python", 43));
        courses.add(new Course("Javascript", 150));
        courses.add(new Course("Java 11", 113));
        courses.add(new Course("C#", 55));

        courses.sort(Comparator.comparing(Course::getName));

        courses.forEach(c -> System.out.println(c.getName()));

        System.out.println("-------------------------------");
        var stream = courses
                .stream()
                .filter(c -> c.getStudents() >= 100)
                .mapToInt(Course::getStudents)
                .sum();

        System.out.println(stream);
        System.out.println("-------------------------------");

        var optional = courses.stream()
                .filter(c -> c.getStudents() >= 100)
                .findAny();
        var course = optional.orElse(null);
        System.out.println(course);
        System.out.println("-------------------------------");

        var a = courses.stream()
                .filter(c -> c.getStudents() >= 100)
                .collect(Collectors.toList());

        var b = courses.stream()
                .filter(c -> c.getStudents() >= 100)
                .collect(Collectors.toMap(
                        Course::getName,
                        Course::getStudents
                ));

        System.out.println(b.get("Java 11"));
    }
}
