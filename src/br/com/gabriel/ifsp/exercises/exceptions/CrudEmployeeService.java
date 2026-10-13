package br.com.gabriel.ifsp.exercises.exceptions;

import java.util.Objects;

public class CrudEmployeeService {
    private final EmployeeRepository repository;

    public CrudEmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void saveEmployee(Employee e) {
        Objects.requireNonNull(e, "The employee to be saved must not be null.");

        repository.save(e);
    }

    public Employee[] getEmployees() {
        return repository.getEmployees();
    }

    public Employee[] getEmployees(String jobTitle) {
        Objects.requireNonNull(jobTitle, "Job Title must not be null.");

        return repository.getEmployees(jobTitle);
    }

    public void increaseEmployeeSalary(String id, double newSalary) {
        Objects.requireNonNull(id, "Id must not be null.");

        if (newSalary <= 0) throw new IllegalArgumentException("New Salary must be positive.");

        repository.getEmployeeById(id).setSalary(newSalary);
    }

    public void deleteEmployee(String id) {
        Objects.requireNonNull(id, "Id must not be null.");

        repository.delete(id);
    }
}
