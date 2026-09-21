package br.com.gabriel.ifsp.exercises.polymorphism.employee;

import java.util.StringJoiner;

public class FakeEmployeeRepository implements Repository<Employee, String> {
    private Employee[] employees;
    private int numberOfEmployees;

    public FakeEmployeeRepository() {
        employees = new Employee[10];
    }

    private void increaseArraySize() {
        Employee[] copy = employees.clone();

        employees = new Employee[numberOfEmployees * 2];

        for (int i = 0; i < numberOfEmployees; i++) {
            employees[i] = copy[i];
        }
    }

    @Override
    public void saveEntity(Employee entity) {
        if (numberOfEmployees == employees.length) {
            increaseArraySize();
        }

        employees[numberOfEmployees++] = entity;
    }

    @Override
    public Employee findById(String id) {
        for (int i = 0; i < numberOfEmployees; i++) {
            if (employees[i].getId().equals(id)) {
                return employees[i];
            }
        }

        return null;
    }

    @Override
    public Employee[] findAll() {
        Employee[] array = new Employee[numberOfEmployees];

        for (int i = 0; i < numberOfEmployees; i++) {
            array[i] = employees[i];
        }

        return array;
    }

    public String showSavedEmployees() {
        StringJoiner joiner = new StringJoiner("\n");

        for (int i = 0; i < numberOfEmployees; i++) {
            joiner.add(employees[i].toString());
        }

        return joiner.toString();
    }
}
