package br.com.gabriel.claude.exercises.polymorphism.student;

public class FindStudentService {
    private final Repository<String, Student> repository;

    public FindStudentService(Repository<String, Student> repository) {
        this.repository = repository;
    }

    public Student findById(String id) {
        return repository.findById(id);
    }
}
