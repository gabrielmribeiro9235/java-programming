package br.com.gabriel.ifsp.exercises.jdbc.domain.repository;

import java.time.LocalDate;

public interface AverageSalaryCalculator {
    double averageSalary();
    double averageSalary(String jobTitle);
    double averageSalary(LocalDate start, LocalDate end);
}
