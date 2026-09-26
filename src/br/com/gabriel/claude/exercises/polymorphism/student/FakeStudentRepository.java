package br.com.gabriel.claude.exercises.polymorphism.student;

import java.util.StringJoiner;

public class FakeStudentRepository implements Repository<String, Student> {
    private Student[] students;
    private int numberOfStudents;

    public FakeStudentRepository() {
        students = new Student[10];
    }

    private void increaseArraySize() {
        Student[] copy = students.clone();

        students = new Student[numberOfStudents * 2];

        for (int i = 0; i < numberOfStudents; i++) {
            students[i] = copy[i];
        }
    }

    @Override
    public void saveEntity(Student entity) {
        if (entity == null) return;

        if (numberOfStudents == students.length) increaseArraySize();

        students[numberOfStudents++] = entity;
    }

    @Override
    public Student findById(String id) {
        if (id == null) return null;

        for (int i = 0; i < numberOfStudents; i++) {
            if (students[i].getId().equals(id)) return students[i];
        }

        return null;
    }

    public String showAllStudents() {
        StringJoiner joiner = new StringJoiner("\n--------------------------------------------------------\n");

        for (int i = 0; i < numberOfStudents; i++) {
            joiner.add("Student " + (i + 1) + "\n" + students[i].toString());
        }

        return joiner.toString();
    }
}
