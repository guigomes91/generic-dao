package br.com.gomes.genericdao.generic;

import java.util.UUID;

public interface GenericDAO<T, K> {

    T findById(K id);
    T persist(T entity);
}
