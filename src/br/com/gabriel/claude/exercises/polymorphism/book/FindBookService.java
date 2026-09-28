package br.com.gabriel.claude.exercises.polymorphism.book;

public class FindBookService {
    private final Repository<String, Book> repository;

    public FindBookService(Repository<String, Book> repository) {
        this.repository = repository;
    }

    public Book findById(String isbn) {
        return repository.findById(isbn);
    }
}
