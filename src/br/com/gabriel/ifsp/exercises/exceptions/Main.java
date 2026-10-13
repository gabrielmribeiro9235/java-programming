package br.com.gabriel.ifsp.exercises.exceptions;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Company company = new Company();

        Employee john = new Employee("01", "John", "Programmer", 2500, LocalDate.of(2024, 10, 20));
        john.addPaycheck(LocalDate.of(2026, 7, 1));
        john.addPaycheck(LocalDate.of(2026, 8, 3));
        john.addPaycheck(LocalDate.of(2026, 9, 1));

        Employee mary = new Employee("02", "Mary", "Programmer", 3000, LocalDate.of(2022, 10, 20));
        mary.addPaycheck(LocalDate.of(2026, 6, 1));
        mary.addPaycheck(LocalDate.of(2026, 7, 1));
        mary.addPaycheck(LocalDate.of(2026, 8, 3));
        mary.addPaycheck(LocalDate.of(2026, 9, 1));

        company.hire(john);
        company.hire(mary);
        company.hire("03", "Anthony", "Marketing", 4000, LocalDate.of(2021, 10, 20));
        company.hire("04", "Joshua", "Trainee", 1800, LocalDate.of(2023, 9, 20));

        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("Company employees:");
        Arrays.stream(company.getEmployees()).toList().forEach(System.out::println);

        System.out.println("--------------------------------------------------------------------------------------------------------");
        company.fire("04");
        System.out.println("Joshua has been fired");

        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("Company employees:");
        Arrays.stream(company.getEmployees()).toList().forEach(System.out::println);

        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.println("Company programmers:");
        Arrays.stream(company.getEmployees("Programmer")).toList().forEach(System.out::println);

        System.out.println("--------------------------------------------------------------------------------------------------------");
        company.increaseSalary("01", 3500);
        System.out.println("John received a raise");
        System.out.println(Arrays.stream(company.getEmployees()).toList().stream().filter(e -> "01".equals(e.getId())).findFirst().orElse(null));

        System.out.println("--------------------------------------------------------------------------------------------------------");
        Arrays.stream(company.getEmployees()).toList().forEach(e -> company.pay(e.getId()));
        System.out.println("Company employees has received their payment of October");

        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.printf(Locale.US, "Average salary of programmers: US$ %.2f\n", company.averageSalary("Programmer"));

        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.printf(Locale.US, "Average company salary from 06/01/2026 to 09/30/2026: US$ %.2f\n", company.averageSalary(LocalDate.of(2026, 6, 1), LocalDate.of(2026, 9, 30)));

        System.out.println("--------------------------------------------------------------------------------------------------------");
        System.out.printf(Locale.US, "Average company salary (all-time): US$ %.2f\n", company.averageSalary());
    }
}
