package br.com.gabriel.ifsp.exercises.polymorphism.employee;

import java.time.LocalDate;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        Repository<Employee, String> repository = new FakeEmployeeRepository();

        RegisterEmployeeService registerEmployeeService = new RegisterEmployeeService(repository);
        FindEmployeeService findEmployeeService = new FindEmployeeService(repository);
        ShowSavedEmployeesService showSavedEmployeesService = new ShowSavedEmployeesService(repository);

        registerEmployeeService.register(new Employee("01", "John", "Programmer", LocalDate.of(2024, 10, 20), 2500));
        registerEmployeeService.register(new Employee("02", "Mary", "Marketing", LocalDate.of(2022, 10, 20), 3000));
        registerEmployeeService.register(new Employee("03", "Anthony", "Engineer", LocalDate.of(2021, 10, 20), 4000));
        // trying to save another employee with id 01
        registerEmployeeService.register(new Employee("01", "Joshua", "Trainee", LocalDate.of(2023, 9, 20), 1800));


        System.out.println("Employee with id 01:");
        Employee employee1 = findEmployeeService.findById("01");

        if (employee1 != null) {
            System.out.println(employee1);
            double initialBonus = employee1.calculateBonus();

            employee1.setSalary(5500);

            System.out.printf(Locale.US, "%s received a raise, his bonus went from US$ %.2f to US$ %.2f\n", employee1.getName(), initialBonus, employee1.calculateBonus());
        } else {
            System.out.println("There's no employee with id 01");
        }

        System.out.println("\nAll employees saved:");
        System.out.println(showSavedEmployeesService.showSavedEmployees());
    }
}
