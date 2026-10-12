package br.com.gabriel.ifsp.exercises.exceptions;

public interface EmployeeRepository {
    void save(Employee e);
    Employee getEmployeeById(String id);
    Employee[] getEmployees();
    Employee[] getEmployees(String jobTitle);
    void delete(Employee e);
    void delete(String id);
}
