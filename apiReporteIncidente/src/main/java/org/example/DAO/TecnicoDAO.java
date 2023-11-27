package org.example.DAO;


import org.example.config.DBConfig;
import org.example.model.Tecnico;

import javax.persistence.EntityManager;

public class TecnicoDAO extends AbstractJpaDAO<Tecnico> {

    public TecnicoDAO(EntityManager entityManager) {
        super(Tecnico.class, entityManager);
    }



}