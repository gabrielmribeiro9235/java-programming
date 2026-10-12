package br.com.gabriel.ifsp.exercises.exceptions;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Objects;

public class Paycheck {
    private final LocalDate payday;
    private final double salary;

    public Paycheck(LocalDate payday, double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary must be positive.");
        }

        if (payday.getDayOfWeek() == DayOfWeek.SATURDAY || payday.getDayOfWeek() == DayOfWeek.SUNDAY) {
            throw new PaymentOnNonBusinessDayException("The payment date must be a business day.");
        }

        this.payday = payday;
        this.salary = salary;
    }

    public LocalDate getPayday() {
        return payday;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Paycheck paycheck = (Paycheck) o;
        return Double.compare(salary, paycheck.salary) == 0 && Objects.equals(payday, paycheck.payday);
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
