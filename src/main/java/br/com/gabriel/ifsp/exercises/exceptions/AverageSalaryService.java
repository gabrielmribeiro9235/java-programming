package br.com.gabriel.ifsp.exercises.exceptions;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Objects;

public class AverageSalaryService {
    private final EmployeeRepository repository;

    public AverageSalaryService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public double averageSalary() {
        return Arrays.stream(repository.getEmployees())
                .flatMap(Employee::payments)
                .mapToDouble(Paycheck::getSalary)
                .average()
                .orElse(0);
    }

    public double averageSalary(String jobTitle) {
        Objects.requireNonNull(jobTitle, "Job Title must not be null.");

        return Arrays.stream(repository.getEmployees(jobTitle))
                .flatMap(Employee::payments)
                .mapToDouble(Paycheck::getSalary)
                .average()
                .orElse(0);
    }

    public double averageSalary(LocalDate start, LocalDate end) {
        Objects.requireNonNull(start, "The start date must not be null.");
        Objects.requireNonNull(end, "The end date must not be null.");

        return Arrays.stream(repository.getEmployees())
                .flatMap(Employee::payments)
                .filter(p -> !p.getPayday().isBefore(start) && !p.getPayday().isAfter(end))
                .mapToDouble(Paycheck::getSalary)
                .average()
                .orElse(0);
    }
}
