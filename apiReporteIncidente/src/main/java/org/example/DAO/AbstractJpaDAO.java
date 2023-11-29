package org.example.DAO;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public abstract class AbstractJpaDAO<T extends Serializable> {

    private Class<T> clazz;
    private EntityManager entityManager;

    public AbstractJpaDAO(Class<T> clazz, EntityManager entityManager) {
        this.clazz = clazz;
        this.entityManager = entityManager;
    }

    public T findOne(Long id) {
        return entityManager.find(clazz, id);
    }

    public List<T> findAll() {
        return entityManager.createQuery("FROM " + clazz.getSimpleName(), clazz).getResultList();
    }

    public void create(T entity) {
        try {
            entityManager.persist(entity);
        } catch (Exception e) {
            throw new RuntimeException("Error during entity creation", e);
        }
    }

    public T update(T entity) {
        try {
            return entityManager.merge(entity);
        } catch (Exception e) {
            throw new RuntimeException("Error during entity update", e);
        }
    }

    public void delete(T entity) {
        try {
            entityManager.remove(entity);
        } catch (Exception e) {
            throw new RuntimeException("Error during entity deletion", e);
        }
    }

}
