package br.com.gabriel.claude.exercises.polymorphism.product;

public interface Repository<K, T> {
    void saveEntity(T entity);
    T findById(K id);
}
