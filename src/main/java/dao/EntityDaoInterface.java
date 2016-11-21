package dao;

import java.util.List;

/**
 * It contains the basic crud methods for working with database
 * @param <T> - entity
 */

public interface EntityDaoInterface<T> {


    T create(T entity);

    T getById(int id);

    void update(T entity);

    void delete(T entity);

    List<T> getAllEntity();

}
