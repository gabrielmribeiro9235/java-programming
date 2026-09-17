package br.com.gabriel.ifsp.exercises.inheritance.employee;

import java.time.LocalDate;

public abstract sealed class Employee permits FullTimeEmployee, PerHourEmployee {
    private final String id;
    private final String name;
    private final String jobTitle;
    private final LocalDate dateOfEmployment;

    public Employee(String id, String name, String jobTitle, LocalDate dateOfEmployment) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.dateOfEmployment = dateOfEmployment;
    }

    public abstract double salary();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }
}
