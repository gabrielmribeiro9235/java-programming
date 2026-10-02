package br.com.gabriel.ifsp.exercises.collectionsandmaps.employee.declarative;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Company {
    private final Map<String, Employee> employees;

    public Company() {
        employees = new TreeMap<>();
    }

    public void hire(String id, String name, String jobTitle, LocalDate dateOfEmployment, double salary) {
        employees.put(id, new Employee(id, name, jobTitle, dateOfEmployment, salary));
    }

    public void hire(Employee e) {
        employees.put(e.getId(), e);
    }

    public void fire(String id) {
        employees.remove(id);
    }

    public List<Employee> getEmployees() {
        return employees.values().stream().toList();
    }

    public List<Employee> getEmployees(String jobTitle) {
        return employees.values().stream().filter(e -> e.getJobTitle().equals(jobTitle)).toList();
    }

    public void pay(String id) {
        Employee employee = employees.get(id);

        if (employee == null) {
            return;
        }

        employee.addPaycheck(LocalDate.now());
    }

    public void increaseSalary(String id, double newSalary) {
        Employee employee = employees.get(id);

        if (employee == null) {
            return;
        }

        employee.setSalary(newSalary);
    }

    public double averageSalary(String jobTitle) {
         return employees.values().stream()
                 .filter(e -> e.getJobTitle().equals(jobTitle))
                 .flatMap(Employee::payments)
                 .mapToDouble(Paycheck::getSalary)
                 .average()
                 .orElse(0);
    }

    public double averageSalary(LocalDate start, LocalDate end) {
        return employees.values().stream()
                .flatMap(Employee::payments)
                .filter(p -> !p.getPayday().isBefore(start) && !p.getPayday().isAfter(end))
                .mapToDouble(Paycheck::getSalary)
                .average()
                .orElse(0);
    }
}
