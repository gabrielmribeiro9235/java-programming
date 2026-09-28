package br.com.gabriel.claude.exercises.polymorphism.vehicle;

public interface Repository<K, T> {
    void saveEntity(T entity);
    T findById(K id);
    boolean existsById(K id);
}
