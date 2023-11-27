package org.example.DAO;

import org.example.model.Problema;
import org.example.model.Servicio;

import javax.persistence.EntityManager;

public class ProblemaDAO extends AbstractJpaDAO<Problema> {

    public ProblemaDAO(EntityManager entityManager) {
        super(Problema.class, entityManager);
    }



}