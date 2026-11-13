package br.com.gabriel.ifsp.exercises.jdbc.service;

import br.com.gabriel.ifsp.exercises.jdbc.domain.model.Employee;
import br.com.gabriel.ifsp.exercises.jdbc.domain.repository.EmployeeRepository;

import java.time.LocalDate;
import java.util.NoSuchElementException;
import java.util.Objects;

//TODO exatamente assim a parte de injeçào do service. 
public class PayEmployeeService {
    private final EmployeeRepository repository;

    public PayEmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void pay(String id) {
        Objects.requireNonNull(id, "Id must not be null.");

        Employee employee = repository.getEmployeeById(id).orElseThrow(() -> new NoSuchElementException("Employee doesn't exist. employeeId: " + id));

        employee.addPaycheck(LocalDate.now());
    }
}
