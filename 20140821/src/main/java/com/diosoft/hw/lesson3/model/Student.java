package main.java.com.diosoft.hw.lesson3.model;

/**
 * <code>Student</code> POJO class
 *
 * @author a.zamkovyi
 * @version 0.0.1
 */

public class Student {
    private final int age;

    public int getAge() {
        return age;
    }

    public Student(String firstName, String surName, int age) {
        this.firstName = firstName;
        this.surName = surName;
        this.age = age;
    }

    public final String getFirstName() {
        return firstName;
    }

    private final String firstName;

    public String getSurName() {
        return surName;
    }

    private String surName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;

        Student student = (Student) o;

        if (age != student.age) return false;
        if (!firstName.equals(student.firstName)) return false;
        if (!surName.equals(student.surName)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = age;
        result = 31 * result + firstName.hashCode();
        result = 31 * result + surName.hashCode();
        return result;
    }
}
