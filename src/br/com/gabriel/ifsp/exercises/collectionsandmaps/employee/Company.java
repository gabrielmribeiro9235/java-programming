package br.com.gabriel.ifsp.exercises.collectionsandmaps.employee;

import java.time.LocalDate;
import java.util.Iterator;
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
         List<Employee> employeesFilteredByJobTitle = employees.values().stream().filter(e -> e.getJobTitle().equals(jobTitle)).toList();

         double sum = 0;
         int count = 0;
         for (Employee employee : employeesFilteredByJobTitle) {
             Iterator<Paycheck> iterator = employee.iteratorPaycheck();

             while (iterator.hasNext()) {
                 final Paycheck paycheck = iterator.next();
                 sum += paycheck.getSalary();
                 count++;
             }
         }

         return sum / count;
    }

    public double averageSalary(LocalDate start, LocalDate end) {
        double sum = 0;
        int count = 0;

        for (Employee employee : employees.values()) {
            Iterator<Paycheck> iterator = employee.iteratorPaycheck();

            while (iterator.hasNext()) {
                final Paycheck paycheck = iterator.next();

                if (paycheck.getPayday().isAfter(start) && paycheck.getPayday().isBefore(end) || paycheck.getPayday().equals(start) || paycheck.getPayday().equals(end)) {
                    sum += paycheck.getSalary();
                    count++;
                }
            }
        }

        return sum / count;
    }
}
