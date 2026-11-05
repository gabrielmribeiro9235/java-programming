package br.com.gabriel.claude.exercises.polymorphism.product;

public class RegisterProductService {
    private final Repository<Integer, Product> repository;

    public RegisterProductService(Repository<Integer, Product> repository) {
        this.repository = repository;
    }

    public void register(Product p) {
        if (repository.findById(p.getId()) != null) return;

        repository.saveEntity(p);
    }
}
