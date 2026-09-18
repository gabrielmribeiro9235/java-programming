package br.com.gabriel.ifsp.exercises.polymorphism.employee;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

public class Employee {
    private final String id;
    private final String name;
    private final String jobTitle;
    private double salary;
    private final LocalDate dateOfEmployment;

    public Employee(String id, String name, String jobTitle, LocalDate dateOfEmployment, double salary) {
        this.id = id;
        this.name = name;
        this.jobTitle = jobTitle;
        this.dateOfEmployment = dateOfEmployment;
        this.salary = salary;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public double getSalary() {
        return salary;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", jobTitle='" + getJobTitle() + '\'' +
                ", salary=" + getSalary() +
                ", dateOfEmployment=" + getDateOfEmployment() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(getId(), employee.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    public int getYearsOfService() {
        return Period.between(dateOfEmployment, LocalDate.now()).getYears();
    }

    public double calculateBonus() {
        double bonusPercentage = 0.05;

        if (getYearsOfService() >= 5) {
            bonusPercentage += 0.1;
        }

        return salary * bonusPercentage;
    }
}
