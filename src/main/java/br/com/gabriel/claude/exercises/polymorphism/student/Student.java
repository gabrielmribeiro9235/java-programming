package br.com.gabriel.claude.exercises.polymorphism.student;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Student {
    private final String id;
    private final String name;
    private final String course;
    private double gpa;
    private final LocalDate enrollmentDate;

    public Student(String id, String name, String course, double gpa, LocalDate enrollmentDate) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.gpa = gpa;
        this.enrollmentDate = enrollmentDate;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCourse() {
        return course;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public LocalDate getEnrollmentDate() {
        return enrollmentDate;
    }

    public int getYearsEnrolled() {
        return Period.between(enrollmentDate, LocalDate.now()).getYears();
    }

    public boolean isEligibleForGraduation() {
        return getYearsEnrolled() >= 4 && gpa >= 6.0;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(id, student.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", course='" + getCourse() + '\'' +
                ", gpa=" + getGpa() +
                ", enrollmentDate=" + getEnrollmentDate() +
                '}';
    }
}
