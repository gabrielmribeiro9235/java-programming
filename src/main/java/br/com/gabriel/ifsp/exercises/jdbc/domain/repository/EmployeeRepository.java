package br.com.gabriel.ifsp.exercises.jdbc.domain.repository;

import br.com.gabriel.ifsp.exercises.jdbc.domain.model.Employee;

import java.util.Optional;

public interface EmployeeRepository {
    void save(Employee employee);
    Optional<Employee> getEmployeeById(String id);
    Employee[] getEmployees();
    Employee[] getEmployees(String jobTitle);
    void updateSalary(String id, double newSalary);
    void delete(String id);
}
