package br.com.gabriel.ifsp.exercises.polymorphism.employee;

public class RegisterEmployeeService {
    private final Repository<Employee, String> repository;

    public RegisterEmployeeService(Repository<Employee, String> repository) {
        this.repository = repository;
    }

    public void register(Employee e) {
        if (repository.findById(e.getId()) == null) {
            repository.saveEntity(e);
        }
    }
}
