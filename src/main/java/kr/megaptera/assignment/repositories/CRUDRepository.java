package kr.megaptera.assignment.repositories;

import java.util.List;

public interface CRUDRepository<T, E> {
    T save(T t);

    T findById(E e);

    boolean exists(E e);

    List<T> findAll();

    T delete(E e);

    void deleteAll();
}
