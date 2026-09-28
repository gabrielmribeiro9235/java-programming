package br.com.gabriel.claude.exercises.polymorphism.vehicle;

public class FindVehicleService {
    private final Repository<String, Vehicle> repository;

    public FindVehicleService(Repository<String, Vehicle> repository) {
        this.repository = repository;
    }

    public Vehicle findById(String id) {
        return repository.findById(id);
    }
}
