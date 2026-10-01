package br.com.gabriel.ifsp.exercises.collectionsandmaps.employee;

import java.time.LocalDate;

public class Paycheck {
    private final LocalDate payday;
    private final Double salary;

    public Paycheck(LocalDate payday, Double salary) {
        this.payday = payday;
        this.salary = salary;
    }
}
