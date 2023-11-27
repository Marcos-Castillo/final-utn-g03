package org.example.DAO;

import org.example.model.Servicio;
import org.example.model.Tecnico;

import javax.persistence.EntityManager;

public class ServicioDAO extends AbstractJpaDAO<Servicio> {

    public ServicioDAO(EntityManager entityManager) {
        super(Servicio.class, entityManager);
    }



}