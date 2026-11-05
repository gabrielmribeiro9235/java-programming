package br.com.gabriel.ifsp.exercises.exceptions;

import java.time.LocalDate;

public class Company {
    private final CrudEmployeeService crudEmployeeService;
    private final PayEmployeeService payEmployeeService;
    private final AverageSalaryService averageSalaryService;

    public Company() {
        EmployeeRepository repository = new EmployeeRepositoryImpl();
        crudEmployeeService = new CrudEmployeeService(repository);
        payEmployeeService = new PayEmployeeService(repository);
        averageSalaryService = new AverageSalaryService(repository);
    }

    public void hire(Employee employee) {
        try {
            crudEmployeeService.saveEmployee(employee);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void hire(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        try {
            hire(new Employee(id, name, jobTitle, salary, dateOfEmployment));
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void fire(String id) {
        try {
            crudEmployeeService.deleteEmployee(id);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public Employee[] getEmployees() {
        return crudEmployeeService.getEmployees();
    }

    public Employee[] getEmployees(String jobTitle) {
        try {
            return crudEmployeeService.getEmployees(jobTitle);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return new Employee[0];
        }
    }

    public void pay(String id) {
        try {
            payEmployeeService.pay(id);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public void increaseSalary(String id, double newSalary) {
        try {
            crudEmployeeService.increaseEmployeeSalary(id, newSalary);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public double averageSalary() {
        return averageSalaryService.averageSalary();
    }

    public double averageSalary(String jobTitle) {
        try {
            return averageSalaryService.averageSalary(jobTitle);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }

    public double averageSalary(LocalDate start, LocalDate end) {
        try {
            return averageSalaryService.averageSalary(start, end);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return 0;
        }
    }
}
