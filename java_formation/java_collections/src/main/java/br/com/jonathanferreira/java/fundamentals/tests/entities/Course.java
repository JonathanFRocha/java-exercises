package br.com.jonathanferreira.java.fundamentals.tests.entities;

import java.util.*;

public class Course {
    private String name;
    private String teacher;
    private List<Lecture> lectures = new LinkedList<>();
    private Set<Student> students = new HashSet<>();

    public Course(String name, String teacher) {
        this.name = name;
        this.teacher = teacher;
    }

    public String getName() {
        return name;
    }

    public String getTeacher() {
        return teacher;
    }

    public List<Lecture> getLectures() {
        return Collections.unmodifiableList(lectures);
    }

    public void add(Lecture lecture) {
        this.lectures.add(lecture);
    }

    public int getTotalTime() {
        int totalTime = 0;
        for (Lecture l : lectures) {
            totalTime += l.getTime();
        }
        return totalTime;
    }

    public Set<Student> getStudents() {
        return Collections.unmodifiableSet(students);
    }

    public void register(Student student) {
        students.add(student);
    }

    @Override
    public String toString() {
        return "course name:" + name + ", teacher=" + teacher + ", lectures=" + lectures + ", Total Time: " + getTotalTime();
    }


    public boolean isRegistered(Student student) {
        return students.contains(student);
    }
}
