package br.com.gabriel.claude.exercises.polymorphism.client;

public class FindClientService {
    private final Repository<String, Client> repository;

    public FindClientService(Repository<String, Client> repository) {
        this.repository = repository;
    }

    public Client findById(String id) {
        return repository.findById(id);
    }
}
