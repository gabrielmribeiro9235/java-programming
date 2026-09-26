package br.com.gabriel.ifsp.exercises.inheritance.employee;

import java.time.LocalDate;

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
        String superToString = super.toString().split("\\{")[1];

        return "FullTimeEmployee{" +
                superToString.substring(0, superToString.length() -1) +
                ", monthlySalary=" + monthlySalary +
                ", salary=" + salary() +
                "}";
    }
}
