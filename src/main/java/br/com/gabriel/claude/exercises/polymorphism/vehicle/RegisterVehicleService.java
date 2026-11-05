package br.com.gabriel.claude.exercises.polymorphism.vehicle;

public class RegisterVehicleService {
    private final Repository<String, Vehicle> repository;

    public RegisterVehicleService(Repository<String, Vehicle> repository) {
        this.repository = repository;
    }

    public void register(Vehicle v) {
        if (repository.existsById(v.getId())) return;

        repository.saveEntity(v);
    }
}
