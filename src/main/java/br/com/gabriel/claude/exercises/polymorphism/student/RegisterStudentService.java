package br.com.gabriel.claude.exercises.polymorphism.student;

public class RegisterStudentService {
    private final Repository<String, Student> repository;

    public RegisterStudentService(Repository<String, Student> repository) {
        this.repository = repository;
    }

    public boolean register(Student s) {
        if (repository.findById(s.getId()) != null) return false;

        repository.saveEntity(s);
        return true;
    }
}
