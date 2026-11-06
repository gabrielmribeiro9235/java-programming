package br.com.gabriel.ifsp.exercises.jdbc.service;

import br.com.gabriel.ifsp.exercises.jdbc.domain.model.Employee;
import br.com.gabriel.ifsp.exercises.jdbc.domain.repository.EmployeeRepository;

public class CrudEmployeeService {
    private final EmployeeRepository repository;

    public CrudEmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void saveEmployee(Employee e) {
        repository.save(e);
    }

    public Employee[] getEmployees() {
        return repository.getEmployees();
    }

    public Employee[] getEmployees(String jobTitle) {
        return repository.getEmployees(jobTitle);
    }

    public void increaseEmployeeSalary(String id, double newSalary) {
        repository.updateSalary(id, newSalary);
    }

    public void deleteEmployee(String id) {
        repository.delete(id);
    }
}
