package org.example.DAO;

import org.example.model.TipoProblema;

import javax.persistence.EntityManager;

public class TipoProblemaDAO extends AbstractJpaDAO<TipoProblema> {

    public TipoProblemaDAO(EntityManager entityManager) {
        super(TipoProblema.class, entityManager);
    }
}
