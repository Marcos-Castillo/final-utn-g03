package org.example.DAO;

import org.example.model.Especialidad;
import org.example.model.Incidente;

import javax.persistence.EntityManager;

public class EspecialidadDAO extends AbstractJpaDAO<Especialidad> {

    public EspecialidadDAO(EntityManager entityManager) {
        super(Especialidad.class, entityManager);
    }



}