package br.com.gabriel.ifsp.exercises.exceptions;

import java.time.LocalDate;
import java.util.Objects;

public class PayEmployeeService {
    private final EmployeeRepository repository;

    public PayEmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void pay(String id) {
        Objects.requireNonNull(id, "Id must not be null.");

        repository.getEmployeeById(id).addPaycheck(LocalDate.now());
    }
}
