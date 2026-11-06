package br.com.gabriel.ifsp.exercises.jdbc;

import br.com.gabriel.ifsp.exercises.jdbc.application.Company;
import br.com.gabriel.ifsp.exercises.jdbc.domain.model.Employee;
import br.com.gabriel.ifsp.exercises.jdbc.domain.model.Paycheck;
import br.com.gabriel.ifsp.exercises.jdbc.infrastructure.persistence.DatabaseInitializer;
import br.com.gabriel.ifsp.exercises.jdbc.infrastructure.persistence.SqliteAverageSalaryCalculator;
import br.com.gabriel.ifsp.exercises.jdbc.infrastructure.persistence.SqliteEmployeeRepository;
import br.com.gabriel.ifsp.exercises.jdbc.infrastructure.persistence.SqlitePaycheckRepository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

public class Main {
    static void main() {
        DatabaseInitializer.init();

        Company company = new Company(new SqliteEmployeeRepository(), new SqliteAverageSalaryCalculator());

        Employee john = new Employee("01", "John", "Programmer", 2500, LocalDate.of(2024, 10, 20), new SqlitePaycheckRepository("01"));

        try {
            company.hire(john);

            john.addPaycheck(LocalDate.of(2026, 7, 1));
            john.addPaycheck(LocalDate.of(2026, 8, 3));
            john.addPaycheck(LocalDate.of(2026, 9, 1));

            Paycheck paycheck = new Paycheck(LocalDate.of(2026, 10, 1), john.getSalary());
            john.addPaycheck(paycheck.getPayday());
            john.removePaycheck(paycheck);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        Employee mary = new Employee("02", "Mary", "Programmer", 3000, LocalDate.of(2022, 10, 20), new SqlitePaycheckRepository("02"));

        try {
            company.hire(mary);

            mary.addPaycheck(LocalDate.of(2026, 6, 1));
            mary.addPaycheck(LocalDate.of(2026, 7, 1));
            mary.addPaycheck(LocalDate.of(2026, 8, 3));
            mary.addPaycheck(LocalDate.of(2026, 9, 1));
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        try {
            company.hire("03", "Anthony", "Marketing", 4000, LocalDate.of(2021, 10, 20));
            company.hire("04", "Joshua", "Trainee", 1800, LocalDate.of(2023, 9, 20));
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("--------------------------------------------------------------------------------------------------------");
        try {
            System.out.println("Company employees:");
            Arrays.stream(company.getEmployees()).toList().forEach(System.out::println);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.printf("Mary's years of service: %d years\n", mary.getYearsOfService());

        System.out.println("--------------------------------------------------------------------------------------------------------");
        try {
            company.fire("04");
            System.out.println("Joshua has been fired");
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("--------------------------------------------------------------------------------------------------------");
        try {
            System.out.println("Company employees:");
            Arrays.stream(company.getEmployees()).toList().forEach(System.out::println);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("--------------------------------------------------------------------------------------------------------");
        try {
            System.out.println("Company programmers:");
            Arrays.stream(company.getEmployees("Programmer")).toList().forEach(System.out::println);
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("--------------------------------------------------------------------------------------------------------");
        try {
            company.increaseSalary("01", 3500);
            System.out.println("John received a raise");
            System.out.println(Arrays.stream(company.getEmployees()).toList().stream().filter(e -> "01".equals(e.getId())).findFirst().orElse(null));
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("--------------------------------------------------------------------------------------------------------");
        try {
            Arrays.stream(company.getEmployees()).toList().forEach(e -> company.pay(e.getId()));
            System.out.println("Company employees has received their payment of October");
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("--------------------------------------------------------------------------------------------------------");
        try {
            System.out.println("Paychecks of Jonh");
            Iterator<Paycheck> paychecks = john.iteratorPaycheck();

            while (paychecks.hasNext()) {
                System.out.println(paychecks.next());
            }
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("--------------------------------------------------------------------------------------------------------");
        try {
            System.out.printf(Locale.US, "Average salary of programmers: US$ %.2f\n", company.averageSalary("Programmer"));
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("--------------------------------------------------------------------------------------------------------");
        try {
            System.out.printf(Locale.US, "Average company salary from 06/01/2026 to 09/30/2026: US$ %.2f\n", company.averageSalary(LocalDate.of(2026, 6, 1), LocalDate.of(2026, 9, 30)));
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }

        System.out.println("--------------------------------------------------------------------------------------------------------");
        try {
            System.out.printf(Locale.US, "Average company salary (all-time): US$ %.2f\n", company.averageSalary());
        } catch (RuntimeException e) {
            System.err.println(e.getMessage());
        }
    }
}
