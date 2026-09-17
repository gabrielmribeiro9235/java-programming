package br.com.gabriel.ifsp.exercises.inheritance.employee;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public final class FullTimeEmployee extends Employee {
    private double monthlySalary;

    public FullTimeEmployee(String id, String name, String jobTitle, LocalDate dateOfEmployment, double monthlySalary) {
        super(id, name, jobTitle, dateOfEmployment);
        this.monthlySalary = monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    @Override
    public double salary() {
        return monthlySalary;
    }

    @Override
    public String toString() {
        return "FullTimeEmployee{" +
                "id='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", jobTitle='" + getJobTitle() + '\'' +
                ", dateOfEmployment=" + getDateOfEmployment().format(DateTimeFormatter.ofPattern("MM/dd/yyyy")) +
                ", monthlySalary=" + monthlySalary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FullTimeEmployee that = (FullTimeEmployee) o;
        return that.getId().equals(getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
}
