package br.com.gabriel.ifsp.exercises.collectionsandmaps.employee.imperative;

import java.time.LocalDate;
import java.util.Objects;

public class Paycheck {
    private final LocalDate payday;
    private final Double salary;

    public Paycheck(LocalDate payday, Double salary) {
        this.payday = payday;
        this.salary = salary;
    }

    public LocalDate getPayday() {
        return payday;
    }

    public Double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Paycheck paycheck = (Paycheck) o;
        return Objects.equals(payday, paycheck.payday) && Objects.equals(salary, paycheck.salary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(payday, salary);
    }

    @Override
    public String toString() {
        return "Paycheck{" +
                "payday=" + payday +
                ", salary=" + salary +
                '}';
    }
}
