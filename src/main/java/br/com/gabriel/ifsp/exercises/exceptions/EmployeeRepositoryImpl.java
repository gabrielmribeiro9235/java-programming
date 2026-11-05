package br.com.gabriel.ifsp.exercises.exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class EmployeeRepositoryImpl implements EmployeeRepository {
    private final Map<String, Employee> employees;

    public EmployeeRepositoryImpl() {
        employees = new HashMap<>();
    }

    @Override
    public void save(Employee e) {
        Objects.requireNonNull(e, "The employee to be saved must not be null.");

        if (getEmployeeById(e.getId()) == null) employees.put(e.getId(), e);
    }

    @Override
    public Employee getEmployeeById(String id) {
        Objects.requireNonNull(id, "Id must not be null.");

        return employees.get(id);
    }

    @Override
    public Employee[] getEmployees() {
        return employees.values().toArray(new Employee[0]);
    }

    @Override
    public Employee[] getEmployees(String jobTitle) {
        Objects.requireNonNull(jobTitle, "Job Title must not be null.");

        return employees.values().stream().filter(e -> jobTitle.equals(e.getJobTitle())).toArray(Employee[]::new);
    }

    @Override
    public void delete(Employee e) {
        Objects.requireNonNull(e, "The employee to be deleted must not be null.");
        delete(e.getId());
    }

    @Override
    public void delete(String id) {
        Objects.requireNonNull(id, "Id must not be null.");

        employees.remove(id);
    }
}
