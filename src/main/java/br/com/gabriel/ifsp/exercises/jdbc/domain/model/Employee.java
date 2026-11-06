package br.com.gabriel.ifsp.exercises.jdbc.domain.model;

import br.com.gabriel.ifsp.exercises.jdbc.domain.exception.PaymentOnNonBusinessDayException;
import br.com.gabriel.ifsp.exercises.jdbc.domain.repository.PaycheckRepository;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import java.util.Objects;
import java.util.stream.Stream;

public class Employee {
    private final String id;
    private final String name;
    private final String jobTitle;
    private double salary;
    private final LocalDate dateOfEmployment;
    private final PaycheckRepository paychecks;

    public Employee(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment, PaycheckRepository paychecks) {
        if (salary <= 0) {
            throw new IllegalArgumentException("Salary must be positive.");
        }
        this.id = Objects.requireNonNull(id, "Id must not be null.");
        this.name = Objects.requireNonNull(name, "Name must not be null.");
        this.jobTitle = Objects.requireNonNull(jobTitle, "Job Title must not be null.");
        this.salary = salary;
        this.dateOfEmployment = Objects.requireNonNull(dateOfEmployment, "Date of Employment must not be null.");
        this.paychecks = paychecks;
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
        try {
            paychecks.add(new Paycheck(payday, salary), id);
        } catch (PaymentOnNonBusinessDayException e) {
            System.err.println(e.getMessage() + " Date received: " + payday.format(DateTimeFormatter.ofPattern("MM-dd-yyy")));
        }
    }

    public void removePaycheck(Paycheck paycheck) {
        paychecks.remove(paycheck, id);
    }

    public Iterator<Paycheck> iteratorPaycheck() {
        return paychecks.iterator(id);
    }

    public Stream<Paycheck> payments() {
        return paychecks.stream(id);
    }
}
