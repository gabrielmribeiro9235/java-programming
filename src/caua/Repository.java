package caua;

public interface Repository<K, T> {
    void saveEntity(T entity);
    T find(K id);
}
