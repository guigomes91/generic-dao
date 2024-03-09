package br.com.gomes.genericdao.generic;

import br.com.gomes.genericdao.model.Venda;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.UUID;

public class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

    @PersistenceContext
    private EntityManager em;

    private Class<T> classEntity;

    public GenericDAOImpl(Class<T> classEntity) {
        this.classEntity = classEntity;
    }

    @Override
    public T findById(K id) {
        return em.find(getEntityClass(), id);
    }

    @Override
    public T persist(T entity) {
        em.persist(entity);
        return entity;
    }

    public EntityManager getEntityManager() {
        return this.em;
    }

    public Class<T> getEntityClass() {
        return this.classEntity;
    }
}
