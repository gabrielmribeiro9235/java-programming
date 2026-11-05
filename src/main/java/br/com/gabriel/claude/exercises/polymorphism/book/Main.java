package br.com.gabriel.claude.exercises.polymorphism.book;

import java.time.LocalDate;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        FakeBookRepository repository = new FakeBookRepository();

        RegisterBookService registerBookService = new RegisterBookService(repository);
        FindBookService findBookService = new FindBookService(repository);

        registerBookService.register(new Book("01", "1984", "George Orwell", 328, LocalDate.of(1949, 6, 8)));
        registerBookService.register(new Book("02", "Animal Farm", "George Orwell", 141, LocalDate.of(1945, 8, 17)));
        registerBookService.register(new Book("03", "Economic Policy: Thoughts for Today and Tomorrow", "Ludwig von Mises", 126, LocalDate.of(1979, 1, 1)));
        registerBookService.register(new Book("04", "The Prince", "Nicolau Maquiavel", 144, LocalDate.of(1532, 1, 1)));
        // trying to save another employee with id 01
        registerBookService.register(new Book("01", "A Study in Scarlet", "Arthur Conan Doyle", 160, LocalDate.of(1887, 11, 1)));


        System.out.println("Book with ISBN 01:");
        Book book = findBookService.findById("01");

        if (book != null) {
            System.out.println(book);

            System.out.printf(Locale.US, "\nPopularity score of %s: %.2f\n", book.getTitle(), book.calculatePopularityScore(30_000_000));
        } else {
            System.out.println("There's no book with ISBN 01");
        }

        System.out.println("------------------------------------------------------------------------------------------------");
        System.out.println("All books saved:\n");
        System.out.println(repository.showAllBooks());
    }
}
