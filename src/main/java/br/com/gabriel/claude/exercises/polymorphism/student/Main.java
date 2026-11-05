package br.com.gabriel.claude.exercises.polymorphism.student;

import java.time.LocalDate;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        FakeStudentRepository repository = new FakeStudentRepository();

        RegisterStudentService registerStudentService = new RegisterStudentService(repository);
        FindStudentService findStudentService = new FindStudentService(repository);

        registerStudentService.register(new Student("01", "Joseph Edwards", "ADS", 8.7, LocalDate.of(2023, 6, 20)));
        registerStudentService.register(new Student("02", "Caroline Harrison", "ADS", 9.25, LocalDate.of(2022, 6, 20)));
        registerStudentService.register(new Student("03", "Mary Jane", "BES", 5, LocalDate.of(2021, 6, 20)));
        registerStudentService.register(new Student("04", "John Stevenson", "BCC", 7.75, LocalDate.of(2025, 6, 20)));
        // trying to save another employee with id 01
        registerStudentService.register(new Student("01", "Anthony Joshua", "ADS", 7, LocalDate.of(2026, 6, 20)));

        System.out.println("Student with id 03:");
        Student student = findStudentService.findById("03");

        if (student != null) {
            System.out.println(student);

            System.out.printf("\nIs %s eligible for graduation? %s\n", student.getName(), (student.isEligibleForGraduation() ? "Yes" : "No"));

            student.setGpa(6);

            System.out.printf(Locale.US, "\n%s took the final exam and received a GPA of %.2f\n", student.getName(), student.getGpa());
            System.out.printf("Now, is %s eligible for graduation? %s\n", student.getName(), (student.isEligibleForGraduation() ? "Yes" : "No"));
        } else {
            System.out.println("There's no employee with id 03");
        }

        System.out.println("\n------------------------------------------------------------------------------------------------");
        System.out.println("All students saved:\n");
        System.out.println(repository.showAllStudents());
    }
}
