package br.com.jonathanferreira.java.fundamentals.tests.entities;

public class Lecture implements Comparable {
    private String title;
    private int time;

    public Lecture(String title, int time) {
        this.title = title;
        this.time = time;
    }

    public String getTitle() {
        return title;
    }

    public int getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Lecture: " +title + ", time: " + time + " minutes";
    }


    @Override
    public int compareTo(Object c) {
        Lecture that = (Lecture) c;
        var thatTitle = that.title;
        return this.title.compareTo(that.title);
    }
}
