package br.com.gabriel.ifsp.exercises.inheritance.employee;

import java.time.LocalDate;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        FullTimeEmployee fullTimeEmployee = new FullTimeEmployee("01", "Joseph Edwards", "Programmer", LocalDate.of(2025, 10, 20), 3500);
        PerHourEmployee perHourEmployee = new PerHourEmployee("01", "Joseph Edwards", "Programmer", LocalDate.of(2025, 11, 20), 35, 200);

        System.out.printf(Locale.US, "%s's salary working as a full-time employee: US$ %.2f\n", fullTimeEmployee.getName(), fullTimeEmployee.salary());
        System.out.printf(Locale.US, "%s's salary working as a hourly employee   : US$ %.2f\n\n", perHourEmployee.getName(), perHourEmployee.salary());

        System.out.printf("Is %s working as a full-time employee and working as a hourly employee the same employee? %s\n\n", fullTimeEmployee.getName(), (fullTimeEmployee.equals(perHourEmployee) ? "Yes" : "No"));

        System.out.printf("Hash code for full-time employee %s: %d\n", fullTimeEmployee.getName(), fullTimeEmployee.hashCode());
        System.out.printf("Hash code for hourly employee %s   : %d\n", perHourEmployee.getName(), perHourEmployee.hashCode());

        System.out.println("\ntoString of the FullTimeEmployee and PerHourEmployee classes:\n");
        System.out.println(fullTimeEmployee);
        System.out.println(perHourEmployee);
    }
}
