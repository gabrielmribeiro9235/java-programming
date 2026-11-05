package br.com.gabriel.ifsp.exercises.polymorphism.employee;

public interface Repository <T, K> {
    void saveEntity(T entity);
    T findById(K id);
    T[] findAll();
}
