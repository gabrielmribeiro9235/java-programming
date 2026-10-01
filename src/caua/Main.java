package caua;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Repository<String, Employee> repository = new RealEmployeeRepository();

        RegisterEmployeeService registerEmployeeService = new RegisterEmployeeService(repository);
        FindEmployeeService findEmployeeService = new FindEmployeeService(repository);

        registerEmployeeService.register(new Employee("01", "John", "Programmer", LocalDate.of(2024, 10, 20), 2500));
        registerEmployeeService.register(new Employee("02", "Mary", "Marketing", LocalDate.of(2022, 10, 20), 3000));
        registerEmployeeService.register(new Employee("03", "Anthony", "Engineer", LocalDate.of(2021, 10, 20), 4000));

        Employee e1 = findEmployeeService.findById("01");
        Employee e2 = findEmployeeService.findById("02");
        Employee e3 = findEmployeeService.findById("03");

        System.out.println(e1);
        System.out.println(e2);
        System.out.println(e3);

        Employee e4 = findEmployeeService.findById("04");

        System.out.println(e4);

        e1.setSalary(5000);
        System.out.println(e1);
    }
}
