package br.com.gabriel.ifsp.exercises.jdbc;

import br.com.gabriel.ifsp.exercises.jdbc.service.AverageSalaryService;
import br.com.gabriel.ifsp.exercises.jdbc.service.CrudEmployeeService;
import br.com.gabriel.ifsp.exercises.jdbc.service.PayEmployeeService;
import br.com.gabriel.ifsp.exercises.jdbc.domain.exception.PaymentOnNonBusinessDayException;
import br.com.gabriel.ifsp.exercises.jdbc.domain.model.Employee;
import br.com.gabriel.ifsp.exercises.jdbc.domain.model.Paycheck;
import br.com.gabriel.ifsp.exercises.jdbc.infrastructure.persistence.DatabaseInitializer;
import br.com.gabriel.ifsp.exercises.jdbc.infrastructure.persistence.SqliteAverageSalaryRepository;
import br.com.gabriel.ifsp.exercises.jdbc.infrastructure.persistence.SqliteEmployeeRepository;
import br.com.gabriel.ifsp.exercises.jdbc.infrastructure.persistence.SqlitePaycheckRepository;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Locale;

public class Main {
    /**
     * For testing purposes only: if today is not a business day, Mockito makes
     * {@code LocalDate.now()} return the next business day, so the demo can run on
     * weekends without throwing {@link PaymentOnNonBusinessDayException}.
     */
    static void main() {
        LocalDate realToday = LocalDate.now();
        LocalDate fakeToday = nextBusinessDay(realToday);

        try (MockedStatic<LocalDate> mocked = Mockito.mockStatic(LocalDate.class, Mockito.CALLS_REAL_METHODS)) {
            mocked.when(LocalDate::now).thenReturn(fakeToday);
            run();
        }
    }

    private static LocalDate nextBusinessDay(LocalDate date) {
        while (date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY) {
            date = date.plusDays(1);
        }

        return date;
    }

    private static void run() {
        try {
            DatabaseInitializer.init();

            SqliteEmployeeRepository repository = new SqliteEmployeeRepository();

            CrudEmployeeService crudService = new CrudEmployeeService(repository);
            PayEmployeeService payService = new PayEmployeeService(repository);
            AverageSalaryService averageService = new AverageSalaryService(new SqliteAverageSalaryRepository());

            Employee john = new Employee("01", "John", "Programmer", 2500, LocalDate.of(2024, 10, 20), new SqlitePaycheckRepository("01"));

            crudService.saveEmployee(john);

            john.addPaycheck(LocalDate.of(2026, 7, 1));
            john.addPaycheck(LocalDate.of(2026, 8, 3));
            john.addPaycheck(LocalDate.of(2026, 9, 1));

            Paycheck paycheck = new Paycheck(LocalDate.of(2026, 10, 1), john.getSalary());
            john.addPaycheck(paycheck.getPayday());
            john.removePaycheck(paycheck);

            Employee mary = new Employee("02", "Mary", "Programmer", 3000, LocalDate.of(2022, 10, 20), new SqlitePaycheckRepository("02"));

            crudService.saveEmployee(mary);

            mary.addPaycheck(LocalDate.of(2026, 6, 1));
            mary.addPaycheck(LocalDate.of(2026, 7, 1));
            mary.addPaycheck(LocalDate.of(2026, 8, 3));
            mary.addPaycheck(LocalDate.of(2026, 9, 1));

            crudService.saveEmployee(new Employee("03", "Anthony", "Marketing", 4000, LocalDate.of(2021, 10, 20), new SqlitePaycheckRepository("03")));
            crudService.saveEmployee(new Employee("04", "Joshua", "Trainee", 1800, LocalDate.of(2023, 9, 20), new SqlitePaycheckRepository("04")));

            System.out.println("--------------------------------------------------------------------------------------------------------");

            System.out.println("Company employees:");
            Arrays.stream(crudService.getEmployees()).toList().forEach(System.out::println);

            System.out.println("--------------------------------------------------------------------------------------------------------");
            System.out.printf("Mary's years of service: %d years\n", mary.getYearsOfService());

            System.out.println("--------------------------------------------------------------------------------------------------------");

            crudService.deleteEmployee("04");
            System.out.println("Joshua has been fired");

            System.out.println("--------------------------------------------------------------------------------------------------------");

            System.out.println("Company employees:");
            Arrays.stream(crudService.getEmployees()).toList().forEach(System.out::println);

            System.out.println("--------------------------------------------------------------------------------------------------------");

            System.out.println("Company programmers:");
            Arrays.stream(crudService.getEmployees("Programmer")).toList().forEach(System.out::println);

            System.out.println("--------------------------------------------------------------------------------------------------------");

            crudService.increaseEmployeeSalary("01", 3500);
            System.out.println("John received a raise");
            System.out.println(Arrays.stream(crudService.getEmployees()).toList().stream().filter(e -> "01".equals(e.getId())).findFirst().orElse(null));

            System.out.println("--------------------------------------------------------------------------------------------------------");

            Arrays.stream(crudService.getEmployees()).toList().forEach(e -> payService.pay(e.getId()));
            System.out.println("Company employees have received their payment of the current month");

            System.out.println("--------------------------------------------------------------------------------------------------------");

            System.out.println("Paychecks of Jonh");
            Iterator<Paycheck> paychecks = john.iteratorPaycheck();

            while (paychecks.hasNext()) {
                System.out.println(paychecks.next());
            }

            System.out.println("--------------------------------------------------------------------------------------------------------");

            System.out.printf(Locale.US, "Average salary of programmers: US$ %.2f\n", averageService.averageSalary("Programmer"));

            System.out.println("--------------------------------------------------------------------------------------------------------");

            System.out.printf(Locale.US, "Average company salary from 06/01/2026 to 09/30/2026: US$ %.2f\n", averageService.averageSalary(LocalDate.of(2026, 6, 1), LocalDate.of(2026, 9, 30)));

            System.out.println("--------------------------------------------------------------------------------------------------------");

            System.out.printf(Locale.US, "Average company salary (all-time): US$ %.2f\n", averageService.averageSalary());
        } catch (RuntimeException e) {
            System.err.println(e.getMessage() + (e.getCause() != null ? " (cause: " + e.getCause().getMessage() + ")" : ""));
        }
    }
}
