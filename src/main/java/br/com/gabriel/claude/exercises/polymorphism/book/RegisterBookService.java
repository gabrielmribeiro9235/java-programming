package br.com.gabriel.claude.exercises.polymorphism.book;

public class RegisterBookService {
    private final Repository<String, Book> repository;

    public RegisterBookService(Repository<String, Book> repository) {
        this.repository = repository;
    }

    public void register(Book b) {
        if (repository.findById(b.getIsbn()) != null) return;

        repository.saveEntity(b);
    }
}
