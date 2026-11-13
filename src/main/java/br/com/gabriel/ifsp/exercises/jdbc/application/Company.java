package br.com.gabriel.ifsp.exercises.jdbc.application;

import br.com.gabriel.ifsp.exercises.jdbc.domain.model.Employee;
import br.com.gabriel.ifsp.exercises.jdbc.domain.repository.AverageSalaryCalculator;
import br.com.gabriel.ifsp.exercises.jdbc.domain.repository.EmployeeRepository;
import br.com.gabriel.ifsp.exercises.jdbc.infrastructure.persistence.SqlitePaycheckRepository;
import br.com.gabriel.ifsp.exercises.jdbc.service.AverageSalaryService;
import br.com.gabriel.ifsp.exercises.jdbc.service.CrudEmployeeService;
import br.com.gabriel.ifsp.exercises.jdbc.service.PayEmployeeService;

//TODO agora que tem os services, eles são sua camada de aplicaçào. Não precisa desse cara no meio não. 
import java.time.LocalDate;

public class Company {
    private final CrudEmployeeService crudEmployeeService;
    private final PayEmployeeService payEmployeeService;
    private final AverageSalaryService averageSalaryService;

    public Company(EmployeeRepository repository, AverageSalaryCalculator calculator) {
        crudEmployeeService = new CrudEmployeeService(repository);
        payEmployeeService = new PayEmployeeService(repository);
        averageSalaryService = new AverageSalaryService(calculator);
    }

    public void hire(Employee employee) {
        crudEmployeeService.saveEmployee(employee);
    }

    public void hire(String id, String name, String jobTitle, double salary, LocalDate dateOfEmployment) {
        hire(new Employee(id, name, jobTitle, salary, dateOfEmployment, new SqlitePaycheckRepository(id)));
    }

    public void fire(String id) {
        crudEmployeeService.deleteEmployee(id);
    }

    public Employee[] getEmployees() {
        return crudEmployeeService.getEmployees();
    }

    public Employee[] getEmployees(String jobTitle) {
        return crudEmployeeService.getEmployees(jobTitle);
    }

    public void pay(String id) {
        payEmployeeService.pay(id);
    }

    public void increaseSalary(String id, double newSalary) {
        crudEmployeeService.increaseEmployeeSalary(id, newSalary);
    }

    public double averageSalary() {
        return averageSalaryService.averageSalary();
    }

    public double averageSalary(String jobTitle) {
        return averageSalaryService.averageSalary(jobTitle);
    }

    public double averageSalary(LocalDate start, LocalDate end) {
        return averageSalaryService.averageSalary(start, end);
    }
}
