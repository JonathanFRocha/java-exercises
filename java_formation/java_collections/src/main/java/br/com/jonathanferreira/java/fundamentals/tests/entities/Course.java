package br.com.jonathanferreira.java.fundamentals.tests.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Course {
    private String name;
    private String teacher;
    private List<Lecture> lectures = new LinkedList<>();

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

    @Override
    public String toString() {
        return "course name:" + name + ", teacher=" + teacher + ", lectures=" + lectures + ", Total Time: " + getTotalTime();
    }
}
