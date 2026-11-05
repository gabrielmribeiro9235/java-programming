package br.com.gabriel.claude.exercises.polymorphism.book;

import java.util.HashMap;
import java.util.StringJoiner;

public class FakeBookRepository implements Repository<String, Book> {
    private final HashMap<String, Book> books;

    public FakeBookRepository() {
        books = new HashMap<>();
    }

    @Override
    public void saveEntity(Book entity) {
        books.put(entity.getIsbn(), entity);
    }

    @Override
    public Book findById(String id) {
        return books.get(id);
    }

    public String showAllBooks() {
        StringJoiner joiner = new StringJoiner("\n------------------------------------------------------------------------------------------------\n");

        int i = 1;
        for (Book b : books.values()) {
            joiner.add("Book " + i + "\n" + b.toString());
            i++;
        }

        return joiner.toString();
    }
}
