package service;

import java.util.List;

/**
 * @param <T> - entity
 */

public interface EntityServiceInterface<T> {
    T create(T entity);

    T getById(int id);

    void update(T entity);

    void delete(T entity);

    List<T> getAllEntity();
}
