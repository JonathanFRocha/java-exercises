package br.com.jonathanferreira.java.fundamentals.tests.entities;

import java.util.Objects;

public class Student{
    private String name;
    private int register;

    public Student() {
    }

    public Student(String name, int register) {
        if(name == null | register == 0) throw new NullPointerException();

        this.name = name;
        this.register = register;
    }

    public String getName() {
        return name;
    }

    public int getRegister() {
        return register;
    }

    @Override
    public String toString() {
        return "[Student name: " + name + ", register: " + register +"]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student that = (Student) o;
        return register == that.register && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode();
    }
}
