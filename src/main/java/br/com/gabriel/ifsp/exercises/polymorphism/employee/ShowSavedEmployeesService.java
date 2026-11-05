package br.com.gabriel.ifsp.exercises.polymorphism.employee;

import java.util.StringJoiner;

public class ShowSavedEmployeesService {
    private final Repository<Employee, String> repository;

    public ShowSavedEmployeesService(Repository<Employee, String> repository) {
        this.repository = repository;
    }

    public String showSavedEmployees() {
        StringJoiner joiner = new StringJoiner("\n");

        Employee[] employees = repository.findAll();
        for (Employee e : employees) {
            joiner.add(e.toString());
        }

        return joiner.toString();
    }
}
