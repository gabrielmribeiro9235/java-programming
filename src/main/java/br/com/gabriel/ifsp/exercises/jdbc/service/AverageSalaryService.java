package br.com.gabriel.ifsp.exercises.jdbc.service;

import br.com.gabriel.ifsp.exercises.jdbc.domain.repository.AverageSalaryCalculator;

import java.time.LocalDate;

public class AverageSalaryService {
    private final AverageSalaryCalculator calculator;

    public AverageSalaryService(AverageSalaryCalculator calculator) {
        this.calculator = calculator;
    }

    public double averageSalary() {
        return calculator.averageSalary();
    }

    public double averageSalary(String jobTitle) {
        return calculator.averageSalary(jobTitle);
    }

    public double averageSalary(LocalDate start, LocalDate end) {
        return calculator.averageSalary(start, end);
    }
}
