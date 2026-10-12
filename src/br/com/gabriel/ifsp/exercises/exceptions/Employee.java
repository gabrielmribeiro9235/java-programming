package br.com.gabriel.ifsp.exercises.exceptions;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

public class Employee {
    private final String id;
    private final String name;
    private final String jobTitle;
    private double salary;
    private final LocalDate dateOfEmployment;
    private final List<Paycheck> paychecks;

    public Employee(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be positive.");
        }
        this.id = Objects.requireNonNull(id, "Id must not be null.");
        this.name = Objects.requireNonNull(name, "Name must not be null.");
        this.jobTitle = Objects.requireNonNull(jobTitle, "Job Title must not be null.");
        this.salary = salary;
        this.dateOfEmployment = Objects.requireNonNull(dateOfEmployment, "Date of Employment must not be null.");
        paychecks = new ArrayList<>();
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

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getDateOfEmployment() {
        return dateOfEmployment;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", salary=" + salary +
                ", dateOfEmployment=" + dateOfEmployment +
                '}';
    }

    public int getYearsOfService() {
        return Period.between(dateOfEmployment, LocalDate.now()).getYears();
    }

    public void addPaycheck(LocalDate payday) {
        paychecks.add(new Paycheck(payday, salary));
    }

    public void removePaycheck(Paycheck paycheck) {
        paychecks.remove(paycheck);
    }

    public Iterator<Paycheck> iteratorPaycheck() {
        return paychecks.iterator();
    }

    public Stream<Paycheck> payments() {
        return paychecks.stream();
    }
}
