package org.example.DAO;

import org.example.config.DBConfig;
import org.example.model.Cliente;
import org.example.model.Incidente;

import javax.persistence.EntityManager;

public class IncidenteDAO extends AbstractJpaDAO<Incidente> {

    public IncidenteDAO(EntityManager entityManager) {
        super(Incidente.class, entityManager);
    }



}