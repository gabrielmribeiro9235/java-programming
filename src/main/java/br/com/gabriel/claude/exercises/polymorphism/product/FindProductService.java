package br.com.gabriel.claude.exercises.polymorphism.product;

public class FindProductService {
    private final Repository<Integer, Product> repository;

    public FindProductService(Repository<Integer, Product> repository) {
        this.repository = repository;
    }

    public Product findById(int id) {
        return repository.findById(id);
    }
}
