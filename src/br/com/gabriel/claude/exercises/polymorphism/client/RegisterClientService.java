package br.com.gabriel.claude.exercises.polymorphism.client;

public class RegisterClientService {
    private final Repository<String, Client> repository;

    public RegisterClientService(Repository<String, Client> repository) {
        this.repository = repository;
    }

    public void register(Client c) {
        if (repository.findById(c.getId()) != null) return;

        repository.saveEntity(c);
    }
}
